package de.timbo.kartoffel.ui.recipes.favorites

import androidx.lifecycle.LiveData
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.SetRecipesSelectedUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

class FavoritesViewModel : BaseViewModel() {

    private val setRecipesSelectedUseCase by inject<SetRecipesSelectedUseCase>()

    private val _proceed = SingleLiveEvent<Any>()
    val proceed: LiveData<Any> = _proceed

    fun resetRecipes() {
        setRecipesSelectedUseCase.reset()
        _proceed.call()
    }
}