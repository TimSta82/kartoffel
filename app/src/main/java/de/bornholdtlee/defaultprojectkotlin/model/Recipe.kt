package de.bornholdtlee.defaultprojectkotlin.model

import android.os.Parcelable
import de.bornholdtlee.defaultprojectkotlin.api.model.RandomRecipesDto
import de.bornholdtlee.defaultprojectkotlin.api.model.SimpleRecipesDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val vegetarian: Boolean?,
    val vegan: Boolean?,
    val glutenFree: Boolean?,
    val dairyFree: Boolean?,
    val veryHealthy: Boolean?,
    val cheap: Boolean?,
    val veryPopular: Boolean?,
    val sustainable: Boolean?,
    val aggregateLikes: Int?,
    val spoonacularScore: Double?,
    val healthScore: Double?,
    val creditsText: String?,
    val license: String?,
    val sourceName: String?,
//    val extendedIngredients: List<ExtendedIngredient?>?, // TODO
    val id: Int?,
    val title: String?,
    val readyInMinutes: Int?,
    val sourceUrl: String?,
    val image: String?,
    val summary: String?,
    val cuisines: List<String?>?,
    val dishTypes: List<String?>?,
    val diets: List<String?>?,
    val spoonacularSourceUrl: String?
//    @SerializedName("instructions")
//    val instructions: String?,
//    @SerializedName("analyzedInstructions")
//    val analyzedInstructions: List<AnalyzedInstruction?>?,
) : Parcelable {

    constructor(randomDto: RandomRecipesDto.RandomRecipeDto) : this(
        vegetarian = randomDto.vegetarian,
        vegan = randomDto.vegan,
        glutenFree = randomDto.glutenFree,
        dairyFree = randomDto.dairyFree,
        veryHealthy = randomDto.veryHealthy,
        cheap = randomDto.cheap,
        veryPopular = randomDto.veryPopular,
        sustainable = randomDto.sustainable,
        aggregateLikes = randomDto.aggregateLikes,
        spoonacularScore = randomDto.spoonacularScore,
        healthScore = randomDto.healthScore,
        creditsText = randomDto.creditsText,
        license = randomDto.license,
        sourceName = randomDto.sourceName,
//        extendedIngredients = randomDto.extendedIngredients, // TODO
        id = randomDto.id,
        title = randomDto.title,
        readyInMinutes = randomDto.readyInMinutes,
        sourceUrl = randomDto.sourceUrl,
        image = randomDto.image,
        summary = randomDto.summary,
        cuisines = randomDto.cuisines,
        dishTypes = randomDto.dishTypes,
        diets = randomDto.diets,
        spoonacularSourceUrl = randomDto.spoonacularSourceUrl
    )

    constructor(simpleDto: SimpleRecipesDto.SimpleRecipeDto) : this(
        vegetarian = simpleDto.vegetarian,
        vegan = simpleDto.vegan,
        glutenFree = simpleDto.glutenFree,
        dairyFree = simpleDto.dairyFree,
        veryHealthy = simpleDto.veryHealthy,
        cheap = simpleDto.cheap,
        veryPopular = simpleDto.veryPopular,
        sustainable = simpleDto.sustainable,
        aggregateLikes = simpleDto.aggregateLikes,
        spoonacularScore = simpleDto.spoonacularScore,
        healthScore = simpleDto.healthScore,
        creditsText = simpleDto.creditsText,
        license = simpleDto.license,
        sourceName = simpleDto.sourceName,
//        extendedIngredients = simpleDto.extendedIngredients, // TODO
        id = simpleDto.id,
        title = simpleDto.title,
        readyInMinutes = simpleDto.readyInMinutes,
        sourceUrl = simpleDto.sourceUrl,
        image = simpleDto.image,
        summary = simpleDto.summary,
        cuisines = simpleDto.cuisines,
        dishTypes = simpleDto.dishTypes,
        diets = simpleDto.diets,
        spoonacularSourceUrl = simpleDto.spoonacularSourceUrl
    )
}