package de.timbo.kartoffel.usecases

import org.koin.core.component.inject

class DiscardWeekAndRecipesUseCase : BaseUseCase() {

    private val discardSuggestedRecipesUseCase by inject<DiscardSuggestedRecipesUseCase>()
    private val discardWeekSuggestionUseCase by inject<DiscardWeekSuggestionUseCase>()

    fun call() {
        discardSuggestedRecipesUseCase.call()
        discardWeekSuggestionUseCase.call()
    }
}
