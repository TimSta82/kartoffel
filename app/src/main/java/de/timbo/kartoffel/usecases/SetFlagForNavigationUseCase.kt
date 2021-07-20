package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.database.AppKeyValueStore
import org.koin.core.component.inject

class SetFlagForNavigationUseCase : BaseUseCase() {

    private val appKeyValueStore by inject<AppKeyValueStore>()

    fun call(hasSelected: Boolean) {
        appKeyValueStore.hasRecipes = hasSelected
    }

    fun reset() {
        appKeyValueStore.hasRecipes = false
    }
}
