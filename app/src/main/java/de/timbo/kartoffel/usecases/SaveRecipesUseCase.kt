package de.timbo.kartoffel.usecases

import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.repositories.RecipeRepository
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SaveRecipesUseCase : BaseUseCase() {
    private val repository by inject<RecipeRepository>()

    fun call(recipes: List<Recipe>) {
        useCaseScope.launch {
            repository.saveRecipes(recipes)
        }
    }
}
