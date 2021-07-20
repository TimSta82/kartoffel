package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SaveWeekSuggestionRecipeIdsUseCase : BaseUseCase() {

    private val weekSuggestionRepository by inject<WeekSuggestionRepository>()

    fun call(ids: List<Int>) {
        useCaseScope.launch {
            weekSuggestionRepository.saveWeekSuggestionIds(ids)
        }
    }
}
