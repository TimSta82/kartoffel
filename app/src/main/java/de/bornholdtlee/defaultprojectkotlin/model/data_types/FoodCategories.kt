package de.bornholdtlee.defaultprojectkotlin.model.data_types

import de.bornholdtlee.defaultprojectkotlin.R

enum class FoodCategory(
    val id: Int,
    val queryMap: Map<String, String>,
    val title: String,
    val imageResId: Int,
    val isRandomEndpoint: Boolean,
    val totalResults: Int // Empiric research of the endpoint with postman. Used to calculate the offset on a random base, but using the NOT random endpoint
) {
    FISH(0, mapOf("diet" to "pescetarian"), "Fish", R.drawable.ic_fish, false, 386),
    CHICKEN(1, mapOf("includeIngredients" to "chicken"), "Chicken", R.drawable.ic_hen, false, 69),
    BEEF(2, mapOf("includeIngredients" to "beef"), "Beef", R.drawable.ic_beef, false, 21),
    PASTA(3, mapOf("query" to "pasta"), "Pasta", R.drawable.ic_pasta, false, 210),
    PORK(4, mapOf("includeIngredients" to "pork"), "Pork", R.drawable.ic_pork, false, 18),
    MYSTERY(9, mapOf("mystery" to "mystery"), "Mystery", R.drawable.ic_mystery, false, -1),
    SOUP(5, mapOf("tags" to "soup"), "Soup", R.drawable.ic_soup, true, 315),
    VEGAN(6, mapOf("diet" to "vegan"), "Vegan", R.drawable.ic_vegan, true, -1),
    VEGETARIAN(7, mapOf("diet" to "vegetarian"), "Vegetarian", R.drawable.ic_vegetarian, true, -1),
    RANDOM(8, mapOf("random" to "random"), "Random", R.drawable.ic_random, true, -1),
    ITALIAN(10, mapOf("tags" to "italian"), "Italian", R.drawable.ic_italian, true, -1),
    GREEK(11, mapOf("tags" to "greek"), "Greek", R.drawable.ic_greece, true, -1),
    CHEAP(12, mapOf("cheap" to "true"), "Cheap", R.drawable.ic_cheap, false, 5076),
    TOP_RATED(13, mapOf("veryPopular" to "true"), "Popular", R.drawable.ic_spotlight, false, 5076),
    HEALTHY(14, mapOf("veryHealthy" to "true"), "Healthy", R.drawable.ic_healthy, false, -1)
}
