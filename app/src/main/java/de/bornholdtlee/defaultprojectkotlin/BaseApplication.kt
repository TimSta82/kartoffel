package de.bornholdtlee.defaultprojectkotlin

import android.app.Application
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import de.bornholdtlee.defaultprojectkotlin.injection.dataModule
import de.bornholdtlee.defaultprojectkotlin.injection.networkModule
import de.bornholdtlee.defaultprojectkotlin.injection.repositoryModule
import de.bornholdtlee.defaultprojectkotlin.injection.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initStetho()
        AndroidThreeTen.init(this)

        startKoin {
            androidContext(this@BaseApplication)
            modules(repositoryModule + useCaseModule + dataModule + networkModule)
        }
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}
