package de.bornholdtlee.defaultprojectkotlin.injection

import de.bornholdtlee.defaultprojectkotlin.usecases.GetQuestionUseCase
import de.bornholdtlee.defaultprojectkotlin.usecases.GetRecipesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetQuestionUseCase() }
    single { GetRecipesUseCase() }
}
