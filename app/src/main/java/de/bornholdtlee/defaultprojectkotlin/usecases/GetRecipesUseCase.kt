package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory
import de.bornholdtlee.defaultprojectkotlin.repositories.RecipesRepository
import de.bornholdtlee.defaultprojectkotlin.utils.DefaultRecipe
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.inject
import kotlin.random.Random

class GetRecipesUseCase : BaseUseCase() {

    private val recipesRepository by inject<RecipesRepository>()

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
                        val randomOffset = Random.nextInt(5)
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
            7 -> UseCaseResult.Success(combinedRecipes)
            else -> UseCaseResult.Failure()
        }
    }
}