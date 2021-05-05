package de.bornholdtlee.defaultprojectkotlin.repositories

import de.bornholdtlee.defaultprojectkotlin.api.RecipeApiInterface
import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.utils.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

abstract class BaseRepository : KoinComponent {

    private val job = SupervisorJob()
    protected val repositoryScope = CoroutineScope(Dispatchers.Main + job)

    protected val api: RecipeApiInterface by inject()

    suspend fun <T> apiCall(block: suspend RecipeApiInterface.() -> Response<T>): ResponseEvaluator.Result<T> {
        val result = kotlin.runCatching { block(api) }
        if (result.exceptionOrNull() != null) {
            Logger.debug(result.exceptionOrNull()?.printStackTrace().toString())
        }
        return ResponseEvaluator.evaluate(result.getOrNull())
    }
}
