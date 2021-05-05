package de.bornholdtlee.defaultprojectkotlin.ui.recipes.current

import androidx.lifecycle.LiveData
import de.bornholdtlee.defaultprojectkotlin.model.Recipe
import de.bornholdtlee.defaultprojectkotlin.ui.BaseViewModel
import de.bornholdtlee.defaultprojectkotlin.usecases.GetRecipesFromDbAsLiveDataUseCase
import de.bornholdtlee.defaultprojectkotlin.utils.SingleLiveEvent
import org.koin.core.component.inject

class CurrentViewModel : BaseViewModel() {

    private val getRecipesFromDbAsLiveDataUseCase by inject<GetRecipesFromDbAsLiveDataUseCase>()

    val recipes: LiveData<List<Recipe>> = getRecipesFromDbAsLiveDataUseCase.call()

    private val _failure = SingleLiveEvent<Any>()
    val failure: LiveData<Any> = _failure

    private val _isLoading = SingleLiveEvent<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


}