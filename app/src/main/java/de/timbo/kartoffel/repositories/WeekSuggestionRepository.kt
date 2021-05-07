package de.timbo.kartoffel.repositories

import de.timbo.kartoffel.database.dao.WeekSuggestionDao
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

    suspend fun getSuggestedWeekIds(): List<Int> = dao.getSuggestedWeekIds()
}
