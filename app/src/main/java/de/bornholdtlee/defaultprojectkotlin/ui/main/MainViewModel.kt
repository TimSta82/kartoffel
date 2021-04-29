package de.bornholdtlee.defaultprojectkotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.bornholdtlee.defaultprojectkotlin.R
import de.bornholdtlee.defaultprojectkotlin.database.AppKeyValueStore
import de.bornholdtlee.defaultprojectkotlin.database.model.Question
import de.bornholdtlee.defaultprojectkotlin.usecases.BaseUseCase.UseCaseResult.Failure
import de.bornholdtlee.defaultprojectkotlin.usecases.BaseUseCase.UseCaseResult.Success
import de.bornholdtlee.defaultprojectkotlin.usecases.GetQuestionUseCase
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import de.bornholdtlee.defaultprojectkotlin.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel : ViewModel(), KoinComponent {

    private val questionUseCase: GetQuestionUseCase by inject()
    private val appKeyValueStore: AppKeyValueStore by inject()

    val questionLiveData: LiveData<List<Question>>

    private val _downloadError: MutableLiveData<Int> = MutableLiveData()
    val downloadError: LiveData<Int> = _downloadError

    private val _downloadSuccess = SingleLiveEvent<Any>()
    val downloadSuccess: LiveData<Any> = _downloadSuccess

    private val _counter: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = 0 }
    val counter: LiveData<Int> = _counter

    init {
        questionLiveData = questionUseCase.getQuestionsLiveData()
        readPreferences()
    }

    fun onIncrementCounter() {
        _counter.value = _counter.value?.plus(1)
    }

    private fun readPreferences() {
        val test = appKeyValueStore.example
        Logger.error("preferences: $test")
    }

    fun makeApiCall() {
        viewModelScope.launch {
            when (questionUseCase.loadQuestions()) {
                is Success -> _downloadSuccess.call()
                is Failure -> _downloadError.postValue(R.string.error_load_questions)
            }
        }
    }
}
