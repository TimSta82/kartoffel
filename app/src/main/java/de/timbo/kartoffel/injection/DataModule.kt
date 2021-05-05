package de.timbo.kartoffel.injection

import androidx.room.Room
import de.timbo.kartoffel.database.AppKeyValueStore
import de.timbo.kartoffel.database.QuestionDb
import de.timbo.kartoffel.database.RecipeDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single { Room.databaseBuilder(androidContext(), QuestionDb::class.java, "questionDb").build() }
    single { get<QuestionDb>().questionDao() }

    single { Room.databaseBuilder(androidContext(), RecipeDb::class.java, "recipeDb").build() }
    single { get<RecipeDb>().recipeDao() }

    single { AppKeyValueStore(androidContext()) }
}
