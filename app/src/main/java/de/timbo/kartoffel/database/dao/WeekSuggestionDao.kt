package de.timbo.kartoffel.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import de.timbo.kartoffel.database.model.WeekSuggestionEntity

@Dao
abstract class WeekSuggestionDao : BaseDao<WeekSuggestionEntity>() {

    @Query("SELECT * FROM WeekSuggestionEntity")
    abstract fun getWeekSuggestionAsLiveData(): LiveData<WeekSuggestionEntity>

    @Query("DELETE FROM WeekSuggestionEntity WHERE week_id =:id")
    abstract suspend fun discardWeekSuggestion(id: Int)

    @Query("SELECT * FROM WeekSuggestionEntity")
    abstract suspend fun getSuggestedWeekEntity(): WeekSuggestionEntity
}
