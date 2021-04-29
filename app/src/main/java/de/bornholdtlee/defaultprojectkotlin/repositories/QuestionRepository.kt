package de.bornholdtlee.defaultprojectkotlin.repositories

import androidx.lifecycle.LiveData
import de.bornholdtlee.defaultprojectkotlin.api.ResponseEvaluator
import de.bornholdtlee.defaultprojectkotlin.api.model.QuestionListDto
import de.bornholdtlee.defaultprojectkotlin.database.dao.QuestionDao
import de.bornholdtlee.defaultprojectkotlin.database.model.Question
import kotlinx.coroutines.launch
import org.koin.core.inject

class QuestionRepository : BaseRepository() {

    private val questionDao: QuestionDao by inject()

    suspend fun startDownload(): ResponseEvaluator.Result<QuestionListDto> {
        return apiCall { api.loadQuestions("android") }
    }

    fun getAllQuestionsLiveData(): LiveData<List<Question>> = questionDao.getAll()

    fun saveQuestions(questionListDto: QuestionListDto) {
        repositoryScope.launch { questionDao.insert(questionListDto.toQuestionList()) }
    }
}
