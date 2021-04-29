package de.bornholdtlee.defaultprojectkotlin.api

import de.bornholdtlee.defaultprojectkotlin.database.AppKeyValueStore
import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.KoinComponent
import org.koin.core.inject

class AuthInterceptor : Interceptor, KoinComponent {

    private val appKeyValueStore by inject<AppKeyValueStore>()

    companion object {
        private const val AUTHORIZATION_KEY = "Authorization"
        private const val BEARER_TOKEN_PREFIX = "Bearer"
    }

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader(AUTHORIZATION_KEY, "$BEARER_TOKEN_PREFIX ${appKeyValueStore.example}")
                .build()
        )
    }
}
