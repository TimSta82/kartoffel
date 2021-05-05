package de.bornholdtlee.defaultprojectkotlin.model

import android.os.Parcelable
import de.bornholdtlee.defaultprojectkotlin.api.model.RandomRecipesDto
import de.bornholdtlee.defaultprojectkotlin.api.model.SimpleRecipesDto
import de.bornholdtlee.defaultprojectkotlin.database.model.RecipeEntity
import de.bornholdtlee.defaultprojectkotlin.extensions.toMcFace
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
    val dishTypes: List<String?>? ,
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
//        cuisines = randomDto.cuisines?.let { cuisines ->
//            cuisines.map{ cuisine ->
//                cuisine ?: "".toMcFace()
//            } },
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

    constructor(entity: RecipeEntity) : this(
        vegetarian = entity.vegetarian,
        vegan = entity.vegan,
        glutenFree = entity.glutenFree,
        dairyFree = entity.dairyFree,
        veryHealthy = entity.veryHealthy,
        cheap = entity.cheap,
        veryPopular = entity.veryPopular,
        sustainable = entity.sustainable,
        aggregateLikes = entity.aggregateLikes,
        spoonacularScore = entity.spoonacularScore,
        healthScore = entity.healthScore,
        creditsText = entity.creditsText,
        license = entity.license,
        sourceName = entity.sourceName,
//        extendedIngredients = entity.extendedIngredients, // TODO
        id = entity.recipeId,
        title = entity.title,
        readyInMinutes = entity.readyInMinutes,
        sourceUrl = entity.sourceUrl,
        image = entity.image,
        summary = entity.summary,
        cuisines = entity.cuisines,
        dishTypes = entity.dishTypes,
        diets = entity.diets,
        spoonacularSourceUrl = entity.spoonacularSourceUrl
    )

    fun toEntity() = RecipeEntity(
        recipeId = id ?: -1,
        title = title ?: "".toMcFace(),
        vegetarian = vegetarian ?: false,
        vegan = vegan ?: false,
        glutenFree = glutenFree ?: false,
        dairyFree = dairyFree ?: false,
        veryHealthy = veryHealthy ?: false,
        cheap = cheap ?: false,
        veryPopular = veryPopular ?: false,
        sustainable = sustainable ?: false,
        aggregateLikes = aggregateLikes ?: -1,
        spoonacularScore = spoonacularScore ?: -1.0,
        healthScore = healthScore ?: -1.0,
        creditsText = creditsText ?: "".toMcFace(),
        license = license ?: "".toMcFace(),
        sourceName = sourceName ?: "".toMcFace(),
//        extendedIngredients = extendedIngredients, // TODO
        readyInMinutes = readyInMinutes ?: -1,
        sourceUrl = sourceUrl ?: "".toMcFace(),
        image = image ?: "".toMcFace(),
        summary = summary ?: "".toMcFace(),
        cuisines = cuisines ?: emptyList(),
        dishTypes = dishTypes ?: emptyList(),
        diets = diets ?: emptyList(),
        spoonacularSourceUrl = spoonacularSourceUrl ?: "".toMcFace()
    )
}
