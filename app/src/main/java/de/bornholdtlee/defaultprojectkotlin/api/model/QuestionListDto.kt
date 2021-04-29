package de.bornholdtlee.defaultprojectkotlin.api.model

import de.bornholdtlee.defaultprojectkotlin.database.model.Question

data class QuestionListDto(

    val items: MutableList<QuestionDto>
) {
    fun toQuestionList(): MutableList<Question> {
        val questions = ArrayList<Question>()
        for (item in items) {
            questions.add(Question(item.questionId, item.title, item.link))
        }
        return questions
    }
}
