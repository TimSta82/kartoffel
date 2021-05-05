package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.api.ResponseEvaluator
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.model.data_types.FoodCategory
import de.timbo.kartoffel.repositories.RecipeRepository
import de.timbo.kartoffel.utils.DefaultRecipe
import de.timbo.kartoffel.utils.Logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.inject
import kotlin.random.Random

class GetRecipesUseCase : BaseUseCase() {

    private val recipesRepository by inject<RecipeRepository>()

    suspend fun call(selectedCategories: List<FoodCategory>): UseCaseResult<List<Recipe>> {
        val combinedRecipes = mutableListOf<Recipe>()
        coroutineScope {
            selectedCategories.map { category ->
                if (category.isRandomEndpoint) {
                    async {
                        when (val result = recipesRepository.getRandomRecipes(category.queryMap)) {
                            is ResponseEvaluator.Result.Success -> {
                                result.response.body()?.randomRecipes?.let { recipesDto ->
                                    val randomRecipes = recipesDto.map { dto -> if (dto != null) Recipe(dto) else DefaultRecipe.recipe }
                                    combinedRecipes.addAll(randomRecipes)
                                }
                            }
                            else -> Logger.debug("No randomRecipes available")
                        }
                    }
                } else {
                    async {
                        val randomOffset = Random.nextInt(category.totalResults)
                        when (val result = recipesRepository.getRecipes(category.queryMap, randomOffset)) {
                            is ResponseEvaluator.Result.Success -> {
                                result.response.body()?.simpleRecipes?.let { recipesDto ->
                                    val simpleRecipes = recipesDto.map { dto -> if (dto != null) Recipe(dto) else DefaultRecipe.recipe }
                                    combinedRecipes.addAll(simpleRecipes)
                                }
                            }
                            else -> Logger.debug("No simpleRecipes available")
                        }
                    }
                }
            }
                .map { it -> it.await() }
        }
        return when (combinedRecipes.size) {
            7 -> handleRecipes(UseCaseResult.Success(combinedRecipes))
            else -> UseCaseResult.Failure()
        }
    }

    private fun handleRecipes(successResponse: UseCaseResult.Success<List<Recipe>>): UseCaseResult<List<Recipe>> {
        recipesRepository.saveRecipes(successResponse.resultObject)
        return successResponse
    }
}
