package de.bornholdtlee.defaultprojectkotlin.api

import de.bornholdtlee.defaultprojectkotlin.api.model.RandomRecipesDto
import de.bornholdtlee.defaultprojectkotlin.api.model.SimpleRecipesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RecipeApiInterface {

    companion object {
        const val API_KEY = "2bb09118087e491483a70b6405b2bd0f"
        const val NUMBER_SIMPLE = 1
        const val NUMBER_RANDOM = 1
    }

    @GET("/recipes/complexSearch?apiKey=${API_KEY}&number=$NUMBER_SIMPLE&fillIngredients=true&addRecipeInformation=true")
    suspend fun getRecipes(@QueryMap query: Map<String, String>, @Query ("offset") offset: Int): Response<SimpleRecipesDto>

    @GET("/recipes/random?apiKey=${API_KEY}&number=$NUMBER_RANDOM")
    suspend fun getRandomRecipes(@QueryMap query: Map<String, String>): Response<RandomRecipesDto>
}
