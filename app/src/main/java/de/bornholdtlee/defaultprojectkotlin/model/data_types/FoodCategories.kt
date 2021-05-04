package de.bornholdtlee.defaultprojectkotlin.model.data_types

import de.bornholdtlee.defaultprojectkotlin.R

enum class FoodCategory(
    val id: Int,
    val queryMap: Map<String, String>,
    val imageResId: Int,
    val isRandomEndpoint: Boolean
) {
    FISH(0, mapOf("diet" to "pescetarian"), R.drawable.ic_fish, false),
    CHICKEN(1, mapOf("includeIngredients" to "chicken"), R.drawable.ic_hen, false),
    MEAT(2, mapOf("includeIngredients" to "meat"), R.drawable.ic_meat, false),
    PASTA(3, mapOf("query" to "pasta"), R.drawable.ic_pasta, false),
    PORK(4, mapOf("includeIngredients" to "pork"), R.drawable.ic_pork, false),
    MYSTERY(9, mapOf("mystery" to "mystery"), R.drawable.ic_mystery, false),
    SOUP(5, mapOf("tags" to "soup"), R.drawable.ic_soup, true),
    VEGAN(6, mapOf("diet" to "vegan"), R.drawable.ic_vegan, true),
    VEGETARIAN(7, mapOf("diet" to "vegetarian"), R.drawable.ic_vegetarian, true),
    RANDOM(8, mapOf("random" to "random"), R.drawable.ic_random, true),
    ITALIAN(10, mapOf("tags" to "italian"), R.drawable.ic_italian, true),
    GREEK(11, mapOf("tags" to "greek"), R.drawable.ic_greece, true),
    CHEAP(12, mapOf("cheap" to "true"), R.drawable.ic_cheap, false),
    TOP_RATED(13, mapOf("veryPopular" to "true"), R.drawable.ic_spotlight, false),
    HEALTHY(14, mapOf("veryHealthy" to "true"), R.drawable.ic_healthy, false)
}
