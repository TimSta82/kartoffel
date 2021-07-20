package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import org.koin.core.component.inject

class GetSuggestedWeekRecipeIdsUseCase : BaseUseCase() {

    private val weekSuggestionRepository by inject<WeekSuggestionRepository>()

    suspend fun call(): List<Int> {
        return weekSuggestionRepository.getSuggestedWeekEntity().recipeIds
    }
}
