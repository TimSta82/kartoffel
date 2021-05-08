package de.timbo.kartoffel.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import org.koin.core.component.inject

class GetSuggestedWeekRecipesIdsAsLiveDataUseCase : BaseUseCase() {

    private val weekSuggestionRepository by inject<WeekSuggestionRepository>()

    fun call(): LiveData<List<Int>> {
        val entity = weekSuggestionRepository.getWeekSuggestionEntityAsLiveData()
        return Transformations.map(entity) { weekSuggestionEntity ->
            return@map weekSuggestionEntity.recipeIds
        }
    }
}
