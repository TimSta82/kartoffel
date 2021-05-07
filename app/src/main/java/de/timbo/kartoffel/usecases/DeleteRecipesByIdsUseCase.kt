package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.RecipeRepository
import org.koin.core.component.inject

class DeleteRecipesByIdsUseCase : BaseUseCase() {

    private val repository by inject<RecipeRepository>()

    fun call(ids: List<Int>) {
        repository.deleteRecipesByIds(ids)
    }
}
