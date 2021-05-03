package de.bornholdtlee.defaultprojectkotlin.model.data_types

import de.bornholdtlee.defaultprojectkotlin.R

enum class FoodCategory(val id: Int, val query: String, val imageResId: Int, var isFrontSide: Boolean) {
    FISH(0, "diet:pescetarian", R.drawable.ic_fish, false),
    CHICKEN(1, "chicken", R.drawable.ic_hen, false),
    MEAT(2, "meat", R.drawable.ic_meat, false),
    PASTA(3, "pasta", R.drawable.ic_pasta, false),
    PORK(4, "pork", R.drawable.ic_pork, false),
    SOUP(5, "soup", R.drawable.ic_soup, false),
    VEGAN(6, "vegan", R.drawable.ic_vegan, false),
    VEGETARIAN(7, "vegetarian", R.drawable.ic_vegetarian, false),
    RANDOM(8, "random", R.drawable.ic_placeholde, false),
    MYSTERY(9, "mystery", R.drawable.ic_surfing, false)
}