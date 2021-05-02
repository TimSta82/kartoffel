package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import org.koin.core.component.KoinComponent

abstract class BaseUseCase : KoinComponent {

    sealed class UseCaseResult<T> {
        data class Success<T>(val resultObject: T) : UseCaseResult<T>()
        class Failure<T> : UseCaseResult<T>()
    }

    fun <T> responseCall(result: ResponseEvaluator.Result<T>): UseCaseResult<T> {
        return when (result) {
            is ResponseEvaluator.Result.Success -> result.response.body()?.let { UseCaseResult.Success(it) } ?: UseCaseResult.Failure()
            else -> UseCaseResult.Failure()
        }
    }
}
