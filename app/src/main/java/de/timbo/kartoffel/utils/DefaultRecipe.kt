package de.timbo.kartoffel.utils

import de.timbo.kartoffel.extensions.toMcFace
import de.timbo.kartoffel.model.Recipe

object DefaultRecipe {
    val recipe = Recipe(
        vegetarian = false,
        vegan = false,
        glutenFree = false,
        dairyFree = false,
        veryHealthy = false,
        cheap = true,
        veryPopular = false,
        sustainable = false,
        aggregateLikes = -1,
        spoonacularScore = -1.0,
        healthScore = -1.0,
        creditsText = "DEFAULT CREDITS",
        license = "DEFAULT LICENSE",
        sourceName = "DEFAULT SOURCE NAME",
//        extendedIngredients = randomDto.extendedIngredients, // TODO
        id = -1,
        title = "DEFAULT TITLE".toMcFace(),
        readyInMinutes = -1,
        sourceUrl = "DEFAULT SOURCE URL",
        image = "DEFAULT IMAGE",
        summary = "DEFAULT SUMMARY",
        cuisines = emptyList(),
        dishTypes = emptyList(),
        diets = emptyList(),
        spoonacularSourceUrl = "DEFAULT spoonacularSourceUrl"
    )
}
