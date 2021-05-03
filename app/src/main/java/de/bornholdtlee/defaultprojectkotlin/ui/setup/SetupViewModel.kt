package de.bornholdtlee.defaultprojectkotlin.ui.setup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory

class SetupViewModel : ViewModel() {

    private val _categories = MutableLiveData<List<FoodCategory>>()
    val categories: LiveData<List<FoodCategory>> = _categories

    private val randCat = FoodCategory.RANDOM
    private val defaultCategories = listOf(randCat, randCat, randCat, randCat, randCat, randCat, randCat, FoodCategory.MYSTERY)

    fun initCategories() {
        _categories.value = defaultCategories
    }

    fun applySelectedCategory(oldPosition: Int, selectedCategory: FoodCategory) {
        val newList = _categories.value?.toMutableList() ?: emptyList<FoodCategory>().toMutableList()
        newList.add(oldPosition, selectedCategory)
        newList.removeAt(oldPosition -1 )
        selectedCategory.isFrontSide = true
        _categories.value = newList
    }
}