package de.bornholdtlee.defaultprojectkotlin.ui.recipes.favorites

import androidx.lifecycle.LiveData
import de.bornholdtlee.defaultprojectkotlin.ui.BaseViewModel
import de.bornholdtlee.defaultprojectkotlin.usecases.SetRecipesSelectedUseCase
import de.bornholdtlee.defaultprojectkotlin.utils.SingleLiveEvent
import org.koin.core.component.inject

class FavoritesViewModel : BaseViewModel() {

    private val setRecipesSelectedUseCase by inject<SetRecipesSelectedUseCase>()

    private val _proceed = SingleLiveEvent<Any>()
    val proceed: LiveData<Any> = _proceed

    fun resetRecipes() {
        setRecipesSelectedUseCase.call(false)
        _proceed.call()
    }
}