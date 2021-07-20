package de.timbo.kartoffel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.timbo.kartoffel.usecases.HasRecipesSelectedUseCase
import org.koin.core.component.inject

class MainViewModel : BaseViewModel() {

    private val hasRecipesSelectedUseCase by inject<HasRecipesSelectedUseCase>()

    private val _hasRecipes = MutableLiveData<Boolean>()
    val hasRecipes: LiveData<Boolean> = _hasRecipes

    fun checkForRecipes() {
        _hasRecipes.value = hasRecipesSelectedUseCase.call()
    }
}
