package de.bornholdtlee.defaultprojectkotlin.injection

import androidx.room.Room
import de.bornholdtlee.defaultprojectkotlin.database.AppKeyValueStore
import de.bornholdtlee.defaultprojectkotlin.database.QuestionDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single { Room.databaseBuilder(androidContext(), QuestionDb::class.java, "questionDb").build() }

    single { get<QuestionDb>().questionDao() }

    single { AppKeyValueStore(androidContext()) }
}
