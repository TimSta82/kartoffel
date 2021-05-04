package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import de.bornholdtlee.defaultprojectkotlin.repositories.RecipesRepository
import de.bornholdtlee.defaultprojectkotlin.utils.DefaultRecipe
import org.koin.core.component.inject

class GetRandomRecipesUseCase : BaseUseCase() {

    private val recipeRepository by inject<RecipesRepository>()

    suspend fun call(number: Int): UseCaseResult<List<Recipe>> {
        return when (val result = recipeRepository.getRandomRecipes(number)) {
            is ResponseEvaluator.Result.Success -> {
                result.response.body()?.let { recipesDto ->
                    val recipes = recipesDto.randomRecipes?.map { recipeDto ->
                        if (recipeDto != null) Recipe(recipeDto) else DefaultRecipe.recipe
                    }
                    recipes?.let {
                        UseCaseResult.Success(it)
                    } ?: UseCaseResult.Failure()
                } ?: UseCaseResult.Failure()
            }
            else -> UseCaseResult.Failure()
        }
    }
}