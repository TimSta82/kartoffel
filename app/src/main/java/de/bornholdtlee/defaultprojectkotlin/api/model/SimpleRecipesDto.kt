package de.bornholdtlee.defaultprojectkotlin.api.model


import com.google.gson.annotations.SerializedName

data class SimpleRecipesDto(
    @SerializedName("results")
    val simpleRecipes: List<SimpleRecipeDto?>?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("totalResults")
    val totalResults: Int?
) {
    data class SimpleRecipeDto(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("usedIngredientCount")
        val usedIngredientCount: Int?,
        @SerializedName("missedIngredientCount")
        val missedIngredientCount: Int?,
        @SerializedName("missedIngredients")
        val missedIngredients: List<MissedIngredient?>?,
        @SerializedName("likes")
        val likes: Int?,
        @SerializedName("usedIngredients")
        val usedIngredients: List<Any?>?,
        @SerializedName("unusedIngredients")
        val unusedIngredients: List<Any?>?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("imageType")
        val imageType: String?
    ) {
        data class MissedIngredient(
            @SerializedName("id")
            val id: Int?,
            @SerializedName("amount")
            val amount: Double?,
            @SerializedName("unit")
            val unit: String?,
            @SerializedName("unitLong")
            val unitLong: String?,
            @SerializedName("unitShort")
            val unitShort: String?,
            @SerializedName("aisle")
            val aisle: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("original")
            val original: String?,
            @SerializedName("originalString")
            val originalString: String?,
            @SerializedName("originalName")
            val originalName: String?,
            @SerializedName("metaInformation")
            val metaInformation: List<String?>?,
            @SerializedName("meta")
            val meta: List<String?>?,
            @SerializedName("extendedName")
            val extendedName: String?,
            @SerializedName("image")
            val image: String?
        )
    }
}