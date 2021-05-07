package de.timbo.kartoffel.ui.setup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.timbo.kartoffel.extensions.launch
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.model.data_types.FoodCategory
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.BaseUseCase
import de.timbo.kartoffel.usecases.GetRecipesUseCase
import de.timbo.kartoffel.usecases.SetRecipesSelectedUseCase
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

class SetupViewModel : BaseViewModel() {

    private val getRecipesUseCase by inject<GetRecipesUseCase>()
    private val setRecipesUseCase by inject<SetRecipesSelectedUseCase>()

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    private val _success = SingleLiveEvent<Any>() // TODO rename precisely when flow is considered e.g. _showPreview,
    val success: LiveData<Any> = _success

    private val _failure = SingleLiveEvent<Any>()
    val failure: LiveData<Any> = _failure

    private val _isLoading = SingleLiveEvent<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

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
        when (oldPosition) {
            1 -> _one.value = selectedCategory
            2 -> _two.value = selectedCategory
            3 -> _three.value = selectedCategory
            4 -> _four.value = selectedCategory
            5 -> _five.value = selectedCategory
            6 -> _six.value = selectedCategory
            7 -> _seven.value = selectedCategory
            else -> {
            }
        }
    }

    private fun collectCategories(): List<FoodCategory> {
        return listOf(
            _one.value!!,
            _two.value!!,
            _three.value!!,
            _four.value!!,
            _five.value!!,
            _six.value!!,
            _seven.value!!
        )
    }

    fun submitSetup() {
        _success.callAsync() // TODO remove
        /**
         * TODO uncomment when select screen looks good
         */
//        _isLoading.value = true
//        launch {
//            when (val result = getRecipesUseCase.call(collectCategories())) {
//                is BaseUseCase.UseCaseResult.Success -> {
//                    setRecipesUseCase.call(true)
//                    _success.callAsync()
//                }
//                else -> _failure.callAsync()
//            }
//            _isLoading.postValue(false)
//        }
    }
}
