package de.timbo.kartoffel.ui.setup.suggestion

import androidx.lifecycle.LiveData
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.DiscardWeekAndRecipesUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

class SuggestionViewModel : BaseViewModel() {

    private val discardWeekAndRecipesUseCase by inject<DiscardWeekAndRecipesUseCase>()

    private val _discarded = SingleLiveEvent<Any>()
    val discarded: LiveData<Any> = _discarded

    fun discardSuggestion() {
        discardWeekAndRecipesUseCase.call()
        _discarded.call()
    }
}
