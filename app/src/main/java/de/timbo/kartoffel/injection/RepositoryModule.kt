package de.timbo.kartoffel.injection

import de.timbo.kartoffel.repositories.QuestionRepository
import de.timbo.kartoffel.repositories.RecipeRepository
import de.timbo.kartoffel.repositories.WeekSuggestionRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { QuestionRepository() }
    single { RecipeRepository() }
    single { WeekSuggestionRepository() }
}
