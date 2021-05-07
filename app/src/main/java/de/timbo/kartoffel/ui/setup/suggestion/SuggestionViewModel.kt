package de.timbo.kartoffel.ui.setup.suggestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.DeleteRecipesByIdsUseCase
import de.timbo.kartoffel.usecases.DiscardWeekSuggestionUseCase
import de.timbo.kartoffel.usecases.GetSuggestedWeekRecipesIdsUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SuggestionViewModel : BaseViewModel() {

    private val discardWeekSuggestionUseCase by inject<DiscardWeekSuggestionUseCase>()
    private val getSuggestedWeekRecipesIdsUseCase by inject<GetSuggestedWeekRecipesIdsUseCase>()
    private val deleteRecipesByIdsUseCase by inject<DeleteRecipesByIdsUseCase>()

    private val _discarded = SingleLiveEvent<Any>()
    val discarded: LiveData<Any> = _discarded

    fun discardSuggestion() {
        discardWeekSuggestionUseCase.call()
        viewModelScope.launch {
            val idsToDelete = getSuggestedWeekRecipesIdsUseCase.call()
            deleteRecipesByIdsUseCase.call(idsToDelete)
            _discarded.call()
        }
    }
}
