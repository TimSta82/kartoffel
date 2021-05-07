package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import org.koin.core.component.inject

class GetSuggestedWeekRecipesIdsUseCase : BaseUseCase() {

    private val weekSuggestionRepository by inject<WeekSuggestionRepository>()

    suspend fun call(): List<Int> {
        return weekSuggestionRepository.getSuggestedWeekIds()
    }
}
