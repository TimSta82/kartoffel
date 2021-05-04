package de.bornholdtlee.defaultprojectkotlin.injection

import de.bornholdtlee.defaultprojectkotlin.usecases.*
import org.koin.dsl.module
import kotlin.math.sin

val useCaseModule = module {

    single { GetQuestionUseCase() }
    single { GetCombinedRecipesUseCase() }
    single { GetRandomRecipesUseCase() }
    single { GetSimpleRecipesUseCase() }
    single { GetRecipesUseCase() }
}
