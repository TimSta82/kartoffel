package de.timbo.kartoffel.injection

import de.timbo.kartoffel.usecases.*
import org.koin.dsl.module

val useCaseModule = module {

    single { GetQuestionUseCase() }
    single { GetRecipesUseCase() }
    single { GetRecipesFromDbAsLiveDataUseCase() }
    single { HasRecipesSelectedUseCase() }
    single { SetRecipesSelectedUseCase() }
}
