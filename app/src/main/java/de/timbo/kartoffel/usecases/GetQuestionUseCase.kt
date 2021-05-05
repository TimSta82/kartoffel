package de.bornholdtlee.defaultprojectkotlin.usecases

import de.bornholdtlee.defaultprojectkotlin.repositories.QuestionRepository
import org.koin.core.component.inject

class GetQuestionUseCase : BaseUseCase() {

    private val questionRepository: QuestionRepository by inject()

//    suspend fun loadQuestions(): UseCaseResult<QuestionListDto> {
//        return when (val response = responseCall(questionRepository.startDownload())) {
//            is UseCaseResult.Success -> handleQuestions(response)
//            is UseCaseResult.Failure -> response
//        }
//    }
//
//    private fun handleQuestions(successResponse: UseCaseResult.Success<QuestionListDto>): UseCaseResult<QuestionListDto> {
//        questionRepository.saveQuestions(successResponse.resultObject)
//        return successResponse
//    }
//
//    fun getQuestionsLiveData() = questionRepository.getAllQuestionsLiveData()
}
