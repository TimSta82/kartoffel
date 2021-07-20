package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.RecipeRepository
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class DiscardSuggestedRecipesUseCase : BaseUseCase() {

    private val repository by inject<RecipeRepository>()
    private val getSuggestionRecipeIdsUseCase by inject<GetSuggestedWeekRecipeIdsUseCase>()

    fun call() {
        useCaseScope.launch {
            val ids = getSuggestionRecipeIdsUseCase.call()
            repository.deleteRecipesByIds(ids)
        }
    }
}
