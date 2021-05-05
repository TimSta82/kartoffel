package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.database.AppKeyValueStore
import org.koin.core.component.inject

class HasRecipesSelectedUseCase: BaseUseCase() {

    private val appKeyValueStore by inject<AppKeyValueStore>()

    fun call() = appKeyValueStore.hasRecipes
}