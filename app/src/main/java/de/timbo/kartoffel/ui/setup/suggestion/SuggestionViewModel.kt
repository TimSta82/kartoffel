package de.timbo.kartoffel.ui.setup.suggestion

import androidx.lifecycle.LiveData
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.DeleteRecipesByIdsUseCase
import de.timbo.kartoffel.usecases.DiscardWeekSuggestionUseCase
import de.timbo.kartoffel.usecases.GetSuggestedWeekRecipesIdsAsLiveDataUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

class SuggestionViewModel : BaseViewModel() {

    private val discardWeekSuggestionUseCase by inject<DiscardWeekSuggestionUseCase>()
    private val getSuggestedWeekRecipesIdsAsLiveDataUseCase by inject<GetSuggestedWeekRecipesIdsAsLiveDataUseCase>()
    private val deleteRecipesByIdsUseCase by inject<DeleteRecipesByIdsUseCase>()

    private val _discarded = SingleLiveEvent<Any>()
    val discarded: LiveData<Any> = _discarded

    private val idsToDelete: LiveData<List<Int>> = getSuggestedWeekRecipesIdsAsLiveDataUseCase.call()

    fun discardSuggestion() {
//        idsToDelete.value?.let { ids ->
//            deleteRecipesByIdsUseCase.call(ids)
//        }
        deleteRecipesByIdsUseCase.call(emptyList<Int>())
        discardWeekSuggestionUseCase.call()
        _discarded.call()
    }
}
