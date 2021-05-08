package de.timbo.kartoffel.injection

import de.timbo.kartoffel.usecases.*
import org.koin.dsl.module

val useCaseModule = module {

    single { GetQuestionUseCase() }
    single { GetRecipesForCategoriesFromApiAndSaveInDbUseCase() }
    single { GetRecipesFromDbAsLiveDataUseCase() }
    single { HasRecipesSelectedUseCase() }
    single { SetFlagForNavigationUseCase() }
    single { SaveRecipesUseCase() }
    single { SaveWeekSuggestionRecipeIdsUseCase() }
    single { DiscardWeekSuggestionUseCase() }
    single { DeleteRecipesByIdsUseCase() }
    single { GetSuggestedWeekRecipesIdsAsLiveDataUseCase() }
}
