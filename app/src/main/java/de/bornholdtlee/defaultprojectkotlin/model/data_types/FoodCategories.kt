package de.bornholdtlee.defaultprojectkotlin.model.data_types

import de.bornholdtlee.defaultprojectkotlin.R

enum class FoodCategory(val id: Int, val queryMap: Map<String, String>, val imageResId: Int) {
    FISH(0, mapOf("diet" to "pescetarian"), R.drawable.ic_fish),
    CHICKEN(1, mapOf("includeIngredients" to "chicken"), R.drawable.ic_hen),
    MEAT(2, mapOf("includeIngredients" to "meat"), R.drawable.ic_meat),
    PASTA(3, mapOf("query" to "pasta"), R.drawable.ic_pasta),
    PORK(4, mapOf("includeIngredients" to "pork"), R.drawable.ic_pork),
    SOUP(5, mapOf("type" to "soup"), R.drawable.ic_soup),
    VEGAN(6, mapOf("diet" to "vegan"), R.drawable.ic_vegan),
    VEGETARIAN(7, mapOf("diet" to "vegetarian"), R.drawable.ic_vegetarian),
    RANDOM(8, mapOf("random" to "random"), R.drawable.ic_placeholde),
    MYSTERY(9, mapOf("mystery" to "mystery"), R.drawable.ic_surfing)
}
