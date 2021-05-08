package de.timbo.kartoffel.ui.setup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.timbo.kartoffel.extensions.launch
import de.timbo.kartoffel.extensions.toMcFace
import de.timbo.kartoffel.model.Recipe
import de.timbo.kartoffel.model.data_types.FoodCategory
import de.timbo.kartoffel.ui.BaseViewModel
import de.timbo.kartoffel.usecases.BaseUseCase
import de.timbo.kartoffel.usecases.GetRecipesForCategoriesFromApiAndSaveInDbUseCase
import de.timbo.kartoffel.usecases.GetRecipesFromDbAsLiveDataUseCase
import de.timbo.kartoffel.usecases.SetFlagForNavigationUseCase
import de.timbo.kartoffel.utils.DefaultRecipe
import de.timbo.kartoffel.utils.SingleLiveEvent
import org.koin.core.component.inject

/** this viewModel is used by CategoriesFragment AND SuggestionFragment */
class SetupViewModel : BaseViewModel() {

    private val getRecipesForCategoriesFromApiAndSaveInDbUseCase by inject<GetRecipesForCategoriesFromApiAndSaveInDbUseCase>()
    private val setFlagForNavigationUseCase by inject<SetFlagForNavigationUseCase>()
    private val getRecipesFromDbAsLiveDataUseCase by inject<GetRecipesFromDbAsLiveDataUseCase>()

    /** CATEGORIES_FRAGMENT */
    private val _categoriesResultSuccess = SingleLiveEvent<Any>() // TODO rename precisely when flow is considered e.g. _showPreview,
    val categoriesResultSuccess: LiveData<Any> = _categoriesResultSuccess

    private val _categoriesResultFailure = SingleLiveEvent<Any>()
    val failure: LiveData<Any> = _categoriesResultFailure

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

    /** SUGGESTION_FRAGMENT */

    private var tempList = listOf<Recipe>()

    //    private val _suggestedRecipes = MutableLiveData<List<List<Recipe>>>()
    val suggestedRecipes: LiveData<List<List<Recipe>>> = getRecipesFromDbAsLiveDataUseCase.callForNestedList()

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

    fun applyCategories() {
//        _categoriesResultSuccess.callAsync() // TODO uncomment if API limit is reached

        _isLoading.value = true
        launch {
            when (val result = getRecipesForCategoriesFromApiAndSaveInDbUseCase.mockCall()) { // TODO remove when DB handling is working
//            when (val result = getRecipesForCategoriesFromApiAndSaveInDbUseCase.call(collectCategories())) {
                is BaseUseCase.UseCaseResult.Success -> {
//                    setFlagForNavigationUseCase.call(true) // TODO
                    _categoriesResultSuccess.callAsync()
                }
                else -> _categoriesResultFailure.callAsync()
            }
            _isLoading.postValue(false)
        }
    }
}
