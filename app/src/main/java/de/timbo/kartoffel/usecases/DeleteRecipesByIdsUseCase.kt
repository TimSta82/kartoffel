package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.repositories.RecipeRepository
import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class DeleteRecipesByIdsUseCase : BaseUseCase() {

    private val repository by inject<RecipeRepository>()
    private val weekRepository by inject<WeekSuggestionRepository>()

    fun call(ids: List<Int>) {
        useCaseScope.launch {
            val x = weekRepository.getSuggestedWeekIds()
            repository.deleteRecipesByIds(x)
        }
    }
}
