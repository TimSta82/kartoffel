package de.bornholdtlee.defaultprojectkotlin.repositories

class RecipesRepository : BaseRepository() {

    suspend fun getRecipes(query: Map<String, String>) = apiCall { getRecipes(query) }
}