package de.timbo.kartoffel.repositories

import androidx.lifecycle.LiveData
import de.timbo.kartoffel.database.dao.WeekSuggestionDao
import de.timbo.kartoffel.database.model.RecipeEntity
import de.timbo.kartoffel.database.model.WeekSuggestionEntity
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class WeekSuggestionRepository : BaseRepository() {

    private val dao by inject<WeekSuggestionDao>()

    suspend fun saveWeekSuggestionIds(ids: List<Int>) {
        val recipeIdsForWeek = ids.map { WeekSuggestionEntity(1, ids) }
        dao.insert(recipeIdsForWeek)
    }

    fun discardWeekSuggestion(id: Int) {
        repositoryScope.launch {
            dao.discardWeekSuggestion(id)
        }
    }

    fun getWeekSuggestionEntityAsLiveData(): LiveData<WeekSuggestionEntity> = dao.getWeekSuggestion()

    suspend fun getSuggestedWeekIds(): List<Int> {
        return dao.getSuggestedWeekIds()
    }
}
