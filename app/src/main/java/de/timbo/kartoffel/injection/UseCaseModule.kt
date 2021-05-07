package de.timbo.kartoffel.injection

import de.timbo.kartoffel.usecases.*
import org.koin.dsl.module

val useCaseModule = module {

    single { GetQuestionUseCase() }
    single { GetRecipesForCategoriesUseCase() }
    single { GetRecipesFromDbAsLiveDataUseCase() }
    single { HasRecipesSelectedUseCase() }
    single { SetRecipesSelectedUseCase() }
}
