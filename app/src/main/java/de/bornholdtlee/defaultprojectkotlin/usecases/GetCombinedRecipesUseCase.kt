package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.api.model.RandomRecipesDto
import de.bornholdtlee.defaultprojectkotlin.api.model.SimpleRecipesDto
import de.bornholdtlee.defaultprojectkotlin.repositories.RecipesRepository
import kotlinx.coroutines.*
import org.koin.core.component.inject

class GetCombinedRecipesUseCase : BaseUseCase() {

//    private val recipeRepository by inject<RecipesRepository>()
//
//    private val recipes = mutableListOf<SimpleRecipesDto.SimpleRecipeDto>()
//    private val randomRecipes = mutableListOf<RandomRecipesDto.RandomRecipeDto>()
//
//    suspend fun call(queries: List<Map<String, String>>): GetRecipesResult {
//        val simpleQueries = queries.filterNot { query -> query.containsKey("random") }
//        val randomQueries = queries.filter { query -> query.containsKey("random") }
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val simpleRecipesResult = simpleQueries.map { async { getSimpleRecipes(it) } }.awaitAll()
//
//
//        }
//
//
//        if (randomQueries.isNotEmpty()) randomQueries.forEach { getRandomRecipes() }
//
//        return getResult(simpleQueries.isNotEmpty(), randomRecipes.isNotEmpty())
//    }
//
//    private fun getResult(isSimpleQueriesEmpty: Boolean, isRandomQueriesEmpty: Boolean): GetRecipesResult {
//        val isSimpleReady = isSimpleQueriesEmpty.not() && recipes.isNotEmpty()
//        val isRandomReady = isRandomQueriesEmpty.not() && randomRecipes.isNotEmpty()
//        return when {
//            isSimpleReady && isRandomReady -> GetRecipesResult.Success(recipes, randomRecipes)
//            isSimpleReady && isRandomReady.not() -> GetRecipesResult.Success(recipes, emptyList())
//            isSimpleReady.not() && isRandomReady -> GetRecipesResult.Success(emptyList(), randomRecipes)
//            else -> GetRecipesResult.Failure
//        }
//    }
//
//    private suspend fun getSimpleRecipes(simpleQuery: Map<String, String>): GetRecipesResult.SimpleRecipesResult {
//        return when (val result = recipeRepository.getRecipes(simpleQuery)) {
//            is ResponseEvaluator.Result.Success -> handleSimpleRecipeResult(result.response.body())
//            else -> GetRecipesResult.SimpleRecipesResult.Failure
//        }
//    }
//
//    private fun handleSimpleRecipeResult(simpleRecipes: SimpleRecipesDto?): GetRecipesResult.SimpleRecipesResult {
//        simpleRecipes?.simpleRecipes?.let { recipesDto ->
//            recipesDto.forEach { simpleRecipeDto ->
//                if (simpleRecipeDto != null) this.recipes.add(simpleRecipeDto)
//            }
//        }
//        return if (recipes.isNotEmpty()) GetRecipesResult.SimpleRecipesResult.Success(recipes) else GetRecipesResult.SimpleRecipesResult.NoMatchingFailure
//    }
//
//    private suspend fun getRandomRecipes(): GetRecipesResult.RandomRecipesResult {
//        return when (val result = recipeRepository.getRandomRecipes()) {
//            is ResponseEvaluator.Result.Success -> handleRandomRecipesResult(result.response.body())
//            else -> GetRecipesResult.RandomRecipesResult.Failure
//        }
//
//    }
//
//    private fun handleRandomRecipesResult(randomRecipesDto: RandomRecipesDto?): GetRecipesResult.RandomRecipesResult {
//        randomRecipesDto?.randomRecipes?.let { recipesDto ->
//            recipesDto.forEach { randomRecipe ->
//                if (randomRecipe != null) randomRecipes.add(randomRecipe)
//            }
//        }
//        return if (randomRecipes.isNotEmpty()) GetRecipesResult.RandomRecipesResult.Success(randomRecipes) else GetRecipesResult.RandomRecipesResult.NoMatchingFailure
//    }
//
//    sealed class GetRecipesResult {
//        sealed class SimpleRecipesResult {
//            data class Success(val recipes: List<SimpleRecipesDto.SimpleRecipeDto>) : SimpleRecipesResult()
//            object NoMatchingFailure : SimpleRecipesResult()
//            object Failure : SimpleRecipesResult()
//        }
//
//        sealed class RandomRecipesResult {
//            data class Success(val recipes: List<RandomRecipesDto.RandomRecipeDto>) : RandomRecipesResult()
//            object NoMatchingFailure : RandomRecipesResult()
//            object Failure : RandomRecipesResult()
//        }
//
//        data class Success(val simpleRecipes: List<SimpleRecipesDto.SimpleRecipeDto>, val randomRecipes: List<RandomRecipesDto.RandomRecipeDto>) : GetRecipesResult()
//        object Failure : GetRecipesResult()
//    }
}