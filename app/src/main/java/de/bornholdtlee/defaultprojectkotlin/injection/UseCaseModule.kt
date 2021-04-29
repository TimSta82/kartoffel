package de.bornholdtlee.defaultprojectkotlin.injection

import de.bornholdtlee.defaultprojectkotlin.usecases.GetQuestionUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetQuestionUseCase() }
}
