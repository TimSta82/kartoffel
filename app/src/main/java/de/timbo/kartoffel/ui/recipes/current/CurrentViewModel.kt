package de.timbo.kartoffel.ui.recipes.current

import androidx.lifecycle.LiveData
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.GetRecipesFromDbAsLiveDataUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

class CurrentViewModel : BaseViewModel() {

    private val getRecipesFromDbAsLiveDataUseCase by inject<GetRecipesFromDbAsLiveDataUseCase>()

    val recipes: LiveData<List<Recipe>> = getRecipesFromDbAsLiveDataUseCase.call()

    private val _failure = SingleLiveEvent<Any>()
    val failure: LiveData<Any> = _failure

    private val _isLoading = SingleLiveEvent<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
}
