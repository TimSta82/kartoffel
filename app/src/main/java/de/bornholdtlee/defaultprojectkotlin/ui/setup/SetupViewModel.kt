package de.bornholdtlee.defaultprojectkotlin.ui.setup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.bornholdtlee.defaultprojectkotlin.model.data_types.FoodCategory

class SetupViewModel : ViewModel() {

    private val _one = MutableLiveData(FoodCategory.RANDOM)
    val one: LiveData<FoodCategory> = _one

    private val _two = MutableLiveData(FoodCategory.RANDOM)
    val two: LiveData<FoodCategory> = _two

    private val _three = MutableLiveData(FoodCategory.RANDOM)
    val three: LiveData<FoodCategory> = _three

    private val _four = MutableLiveData(FoodCategory.RANDOM)
    val four: LiveData<FoodCategory> = _four

    private val _five = MutableLiveData(FoodCategory.RANDOM)
    val five: LiveData<FoodCategory> = _five

    private val _six = MutableLiveData(FoodCategory.RANDOM)
    val six: LiveData<FoodCategory> = _six

    private val _seven = MutableLiveData(FoodCategory.RANDOM)
    val seven: LiveData<FoodCategory> = _seven

    fun applySelectedCategory(oldPosition: Int, selectedCategory: FoodCategory) {
        selectedCategory.isFrontSide = true
        when (oldPosition) {
            1 -> _one.value = selectedCategory
            2 -> _two.value = selectedCategory
            3 -> _three.value = selectedCategory
            4 -> _four.value = selectedCategory
            5 -> _five.value = selectedCategory
            6 -> _six.value = selectedCategory
            7 -> _seven.value = selectedCategory
            else -> {}
        }
    }

    fun submitSetup() {

    }
}