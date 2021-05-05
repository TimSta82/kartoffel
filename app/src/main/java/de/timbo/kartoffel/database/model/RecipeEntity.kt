package de.timbo.kartoffel.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var recipeId: Int,
    var title: String,
    var vegetarian: Boolean,
    var vegan: Boolean,
    var glutenFree: Boolean,
    var dairyFree: Boolean,
    var veryHealthy: Boolean,
    var cheap: Boolean,
    var veryPopular: Boolean,
    var sustainable: Boolean,
    var aggregateLikes: Int,
    var spoonacularScore: Double,
    var healthScore: Double,
    var creditsText: String,
    var license: String,
    var sourceName: String,
//    var extendedIngredients: List<ExtendedIngredient>, // TODO
    var readyInMinutes: Int,
    var sourceUrl: String,
    var image: String,
    var summary: String,
    var cuisines: List<String?>?,
    var dishTypes: List<String?>?,
    var diets: List<String?>?,
    var spoonacularSourceUrl: String
)