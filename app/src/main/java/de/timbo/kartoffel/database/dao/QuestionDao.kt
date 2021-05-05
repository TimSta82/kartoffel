package de.timbo.kartoffel.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import de.timbo.kartoffel.database.model.Question

@Dao
abstract class QuestionDao : BaseDao<Question>() {

    @Query("SELECT * FROM Question")
    abstract fun getAll(): LiveData<List<Question>>

    @Query("SELECT * FROM Question WHERE question_id = :questionId")
    abstract fun getQuestionById(questionId: String): LiveData<Question>

    @Query("DELETE FROM Question")
    abstract suspend fun removeAll()
}
