package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.api.ResponseEvaluator
import de.timbo.kartoffel.extensions.toMcFace
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.model.data_types.FoodCategory
import de.timbo.kartoffel.repositories.RecipeRepository
import de.timbo.kartoffel.utils.DefaultRecipe
import de.timbo.kartoffel.utils.Logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.inject
import kotlin.random.Random

class GetRecipesForCategoriesFromApiAndSaveInDbUseCase : BaseUseCase() {

    private val recipesRepository by inject<RecipeRepository>()
    private val saveWeekSuggestionRecipeIdsUseCase by inject<SaveWeekSuggestionRecipeIdsUseCase>()
    private val saveRecipesUseCase by inject<SaveRecipesUseCase>()

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
        saveRecipesUseCase.call(recipes = successResponse.resultObject)
        saveWeekSuggestionRecipeIdsUseCase.call(successResponse.resultObject.map { recipe -> recipe.id ?: -1 })
        return successResponse
    }

//    suspend fun mockCall(): UseCaseResult<List<Recipe>> {
//        val list = createRecipes()
//        return handleRecipes(UseCaseResult.Success(list.first()))
//    }
//
//    private fun createRecipes(): List<List<Recipe>> {
//        return listOf(
//            listOf(
//                DefaultRecipe.recipe.copy(title = "Ozelot".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/"),
//                DefaultRecipe.recipe.copy(title = "Nasenbär".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/"),
//                DefaultRecipe.recipe.copy(title = "Egon".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/"),
//                DefaultRecipe.recipe.copy(title = "Grütze".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/"),
//                DefaultRecipe.recipe.copy(title = "Suppe".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/"),
//                DefaultRecipe.recipe.copy(title = "Döner".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/"),
//                DefaultRecipe.recipe.copy(title = "Pizza".toMcFace(), id = Random.nextInt(5000), image = "https://www.thispersondoesnotexist.com/")
//            )
//        )
//    }
}
