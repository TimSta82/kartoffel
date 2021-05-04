package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import de.bornholdtlee.defaultprojectkotlin.repositories.RecipesRepository
import de.bornholdtlee.defaultprojectkotlin.utils.DefaultRecipe
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.inject

class GetRecipesUseCase : BaseUseCase() {

    private val recipesRepository by inject<RecipesRepository>()
    private val getRandomRecipesUseCase by inject<GetRandomRecipesUseCase>()

//    suspend fun call(queries: List<Map<String, String>>): UseCaseResult<List<Recipe>> = coroutineScope {
//        val totalSize = queries.size
//        val randomQueriesCount = queries.filter { query -> query.containsKey("random") }.size
//        val simpleQueries = queries.filterNot { query -> query.containsKey("random") }
//
//        val list = mutableListOf<Recipe>()
//
//        val one = async(start = CoroutineStart.LAZY) { getRandomRecipesUseCase.call(randomQueriesCount) }.await()
//        when (one) {
//            is UseCaseResult.Success -> list.addAll(one.resultObject)
////            is UseCaseResult.Success -> UseCaseResult.Success(one.resultObject)
//            else -> UseCaseResult.Failure()
//        }
//    }

    suspend fun call(queries: List<Map<String, String>>): List<Recipe> {
        val combinedRecipes = mutableListOf<Recipe>()
        coroutineScope {
            queries.map { query ->
                if (query.containsKey("random")) {
                    async {
                        when (val result = recipesRepository.getRandomRecipes(1)) {
                            is ResponseEvaluator.Result.Success -> {
                                result.response.body()?.randomRecipes?.let { recipesDto ->
                                    val randomRecipes = recipesDto.map { if (it != null) Recipe(it) else DefaultRecipe.recipe }
                                    combinedRecipes.addAll(randomRecipes)
                                }
                            }
                            else -> {
                            }
                        }
                    }
                } else {
                    async {
                        when (val result = recipesRepository.getRecipes(query)) {
                            is ResponseEvaluator.Result.Success -> {
                                result.response.body()?.simpleRecipes?.let { recipesDto ->
                                    val simpleRecipes = recipesDto.map { if (it != null) Recipe(it) else DefaultRecipe.recipe }
                                    combinedRecipes.addAll(simpleRecipes)
                                }
                            }
                            else -> {
                            }
                        }
                    }
                }
            }
                .map { it -> it.await() }
        }
        return combinedRecipes
    }
}