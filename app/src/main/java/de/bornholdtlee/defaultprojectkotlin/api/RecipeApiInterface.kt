package de.bornholdtlee.defaultprojectkotlin.api

import retrofit2.Response
import retrofit2.http.GET

interface RecipeApiInterface {

    companion object {
        const val API_KEY = "2bb09118087e491483a70b6405b2bd0f"
    }

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(): Response<Any>
}