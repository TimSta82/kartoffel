package de.bornholdtlee.defaultprojectkotlin.injection

import de.bornholdtlee.defaultprojectkotlin.repositories.QuestionRepository
import de.bornholdtlee.defaultprojectkotlin.repositories.RecipesRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { QuestionRepository() }
    single { RecipesRepository() }
}
