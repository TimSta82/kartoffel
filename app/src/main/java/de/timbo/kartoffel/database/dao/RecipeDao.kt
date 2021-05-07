package de.timbo.kartoffel.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import de.timbo.kartoffel.database.model.RecipeEntity

@Dao
abstract class RecipeDao : BaseDao<RecipeEntity>() {

    @Query("SELECT * FROM RecipeEntity")
    abstract fun getAll(): LiveData<List<RecipeEntity>>

    @Query("SELECT * FROM RecipeEntity WHERE id IN (:ids)")
    abstract suspend fun getRecipesByIds(ids: List<Int>) : List<RecipeEntity>
}