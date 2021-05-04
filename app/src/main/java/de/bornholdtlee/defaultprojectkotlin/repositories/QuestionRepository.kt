package de.bornholdtlee.defaultprojectkotlin.repositories

import de.bornholdtlee.defaultprojectkotlin.database.dao.QuestionDao
import org.koin.core.component.inject

class QuestionRepository : BaseRepository() {

    private val questionDao: QuestionDao by inject()

//    suspend fun startDownload(): ResponseEvaluator.Result<QuestionListDto> {
//        return apiCall { api.loadQuestions("android") }
//    }
//
//    fun getAllQuestionsLiveData(): LiveData<List<Question>> = questionDao.getAll()
//
//    fun saveQuestions(questionListDto: QuestionListDto) {
//        repositoryScope.launch { questionDao.insert(questionListDto.toQuestionList()) }
//    }
}
