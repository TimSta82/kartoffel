package de.bornholdtlee.defaultprojectkotlin.repositories

class RecipesRepository : BaseRepository() {

    suspend fun getRecipes(query: Map<String, String>, offset: Int) = apiCall { getRecipes(query, offset) }

    suspend fun getRandomRecipes(query: Map<String, String>) = apiCall { getRandomRecipes(query) }
}
