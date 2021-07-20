package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import org.koin.core.component.inject

class DiscardWeekSuggestionUseCase : BaseUseCase() {

    private val weekSuggestionRepository by inject<WeekSuggestionRepository>()

    fun call() {
        weekSuggestionRepository.discardWeekSuggestion(1)
    }
}
