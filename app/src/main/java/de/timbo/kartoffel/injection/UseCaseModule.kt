package de.bornholdtlee.defaultprojectkotlin.injection

import de.bornholdtlee.defaultprojectkotlin.usecases.*
import org.koin.dsl.module

val useCaseModule = module {

    single { GetQuestionUseCase() }
    single { GetRecipesUseCase() }
    single { GetRecipesFromDbAsLiveDataUseCase() }
    single { HasRecipesSelectedUseCase() }
    single { SetRecipesSelectedUseCase() }
}
