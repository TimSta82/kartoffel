package de.timbo.kartoffel.ui.recipes.favorites

import androidx.lifecycle.LiveData
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.SetFlagForNavigationUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

class FavoritesViewModel : BaseViewModel() {

    private val setFlagForNavigationUseCase by inject<SetFlagForNavigationUseCase>()

    private val _proceed = SingleLiveEvent<Any>()
    val proceed: LiveData<Any> = _proceed

    fun resetRecipes() {
        setFlagForNavigationUseCase.reset()
        _proceed.call()
    }
}
