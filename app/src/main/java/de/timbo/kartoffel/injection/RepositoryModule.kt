package de.timbo.kartoffel.injection

import de.timbo.kartoffel.repositories.QuestionRepository
import de.timbo.kartoffel.repositories.RecipeRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { QuestionRepository() }
    single { RecipeRepository() }
}
