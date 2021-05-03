package de.bornholdtlee.defaultprojectkotlin.api

import de.bornholdtlee.defaultprojectkotlin.api.model.RandomRecipesDto
import de.bornholdtlee.defaultprojectkotlin.api.model.SimpleRecipesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RecipeApiInterface {

    companion object {
        const val API_KEY = "2bb09118087e491483a70b6405b2bd0f"
        const val NUMBER = 3
    }

    @GET("/recipes/complexSearch?apiKey=${API_KEY}&number=$NUMBER")
    suspend fun getRecipes(@QueryMap query: Map<String, String>): Response<SimpleRecipesDto>

    @GET("/recipes/random?apiKey=${API_KEY}&number=$NUMBER")
    suspend fun getRandomRecipes(@QueryMap query: Map<String, String>): Response<RandomRecipesDto>
}
