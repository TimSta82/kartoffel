package de.bornholdtlee.defaultprojectkotlin.repositories

import de.bornholdtlee.defaultprojectkotlin.api.ApiInterface
import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

abstract class BaseRepository : KoinComponent {

    private val job = SupervisorJob()
    protected val repositoryScope = CoroutineScope(Dispatchers.Main + job)

    protected val api: ApiInterface by inject()

    suspend fun <T> apiCall(block: suspend ApiInterface.() -> Response<T>): ResponseEvaluator.Result<T> =
        ResponseEvaluator.evaluate(kotlin.runCatching { block(api) }.getOrNull())
}
