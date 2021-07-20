package de.timbo.kartoffel.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.repositories.RecipeRepository
import org.koin.core.component.inject

class GetRecipesFromDbAsLiveDataUseCase : BaseUseCase() {

    private val recipeRepository by inject<RecipeRepository>()

    fun call(): LiveData<List<Recipe>> {
        val entities = recipeRepository.getRecipeEntitiesAsLiveData()
        return Transformations.map(entities) { recipeEntities ->
            var tempRecipes = mutableListOf<Recipe>()
            recipeEntities.forEach { entity ->
                val recipe = Recipe(entity)
                tempRecipes.add(recipe)
            }
            return@map tempRecipes.toList()
        }
    }

    fun callForNestedList(): LiveData<List<List<Recipe>>> {
        val recipes = call()
        return Transformations.map(recipes) { list ->
            var tempNestedList = mutableListOf<List<Recipe>>()
            list.let {
                tempNestedList.add(it.take(7))
            }
            return@map tempNestedList
        }
    }
}
