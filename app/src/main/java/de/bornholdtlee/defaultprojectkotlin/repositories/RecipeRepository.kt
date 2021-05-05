package de.bornholdtlee.defaultprojectkotlin.repositories

import androidx.lifecycle.LiveData
import de.bornholdtlee.defaultprojectkotlin.database.dao.RecipeDao
import de.bornholdtlee.defaultprojectkotlin.database.model.RecipeEntity
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class RecipeRepository : BaseRepository() {

    private val dao by inject<RecipeDao>()

    suspend fun getRecipes(query: Map<String, String>, offset: Int) = apiCall { getRecipes(query, offset) }

    suspend fun getRandomRecipes(query: Map<String, String>) = apiCall { getRandomRecipes(query) }

    fun saveRecipes(recipes: List<Recipe>) {
        repositoryScope.launch {
            dao.insert(recipes.map { recipe -> recipe.toEntity() })
        }
    }

    fun getRecipeEntitiesAsLiveData(): LiveData<List<RecipeEntity>>  = dao.getAll()
}
