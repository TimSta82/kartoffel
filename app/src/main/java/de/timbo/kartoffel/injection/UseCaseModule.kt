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
    single { GetSuggestedWeekRecipeIdsUseCase() }

    /** These three useCases handle the discarding of suggested recipes. It is needed to save the recipes to get them displayed on the backside of easyFlipView */
    single { DiscardWeekSuggestionUseCase() }
    single { DiscardSuggestedRecipesUseCase() }
    single { DiscardWeekAndRecipesUseCase() }
}
