package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.api.model.SimpleRecipesDto
import de.bornholdtlee.defaultprojectkotlin.repositories.RecipesRepository
import org.koin.core.component.inject

class GetRecipesUseCase : BaseUseCase() {

    private val recipeRepository by inject<RecipesRepository>()

    private val recipes = mutableListOf<SimpleRecipesDto.SimpleRecipeDto>()

    suspend fun call(queries: List<Map<String, String>>) : GetRecipesResult {
        val simpleQueries = queries.filterNot { query -> query.containsKey("random") }
        val randomQueries = queries.filter { query -> query.containsKey("random") }
        simpleQueries.forEach { query ->
            when (val result = recipeRepository.getRecipes(query)) {
                is ResponseEvaluator.Result.Success -> handleResult(result.response.body())
            }
        }
    }

    private fun handleResult(simpleRecipes: SimpleRecipesDto?) {
        simpleRecipes?.simpleRecipes?.let {
            recipes.addAll(it.toMutableList())
        }
    }

    sealed class GetRecipesResult {
        data class Success(val recipes: List<SimpleRecipesDto.SimpleRecipeDto>) : GetRecipesResult()
        object Failure: GetRecipesResult()
    }
}