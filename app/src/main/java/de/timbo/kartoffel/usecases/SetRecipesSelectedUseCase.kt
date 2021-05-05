package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.database.AppKeyValueStore
import org.koin.core.component.inject

class SetRecipesSelectedUseCase : BaseUseCase() {

    private val appKeyValueStore by inject<AppKeyValueStore>()

    fun call(hasSelected: Boolean) {
        appKeyValueStore.hasRecipes = hasSelected
    }

    fun reset() {
        appKeyValueStore.hasRecipes = false
    }
}