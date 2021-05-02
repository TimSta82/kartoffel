package de.bornholdtlee.defaultprojectkotlin.model.data_types

import de.bornholdtlee.defaultprojectkotlin.R

enum class FoodCategory(val query: String, val imageResId: Int) {
    FISH("diet:pescetarian", R.drawable.ic_fish),
    CHICKEN("chicken", R.drawable.ic_hen),
    MEAT("meat", R.drawable.ic_meat),
    PASTA("meat", R.drawable.ic_pasta),
    PORK("meat", R.drawable.ic_pork),
    SOUP("meat", R.drawable.ic_soup),
    VEGAN("meat", R.drawable.ic_vegan),
    VEGETARIAN("meat", R.drawable.ic_vegetarian),
    RANDOM("", R.drawable.ic_placeholde),
    MYSTERY("", R.drawable.ic_surfing)
}