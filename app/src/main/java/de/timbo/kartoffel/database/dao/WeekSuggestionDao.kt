package de.timbo.kartoffel.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import de.timbo.kartoffel.database.model.RecipeEntity
import de.timbo.kartoffel.database.model.WeekSuggestionEntity

@Dao
abstract class WeekSuggestionDao : BaseDao<WeekSuggestionEntity>() {

    @Query("SELECT * FROM WeekSuggestionEntity")
    abstract fun getWeekSuggestion(): LiveData<WeekSuggestionEntity>

    @Query("DELETE FROM WeekSuggestionEntity")
    abstract suspend fun removeWeekSuggestion()
}
