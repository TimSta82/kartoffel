package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.database.AppKeyValueStore
import org.koin.core.component.inject

class HasRecipesSelectedUseCase: BaseUseCase() {

    private val appKeyValueStore by inject<AppKeyValueStore>()

    fun call() = appKeyValueStore.hasRecipes
}