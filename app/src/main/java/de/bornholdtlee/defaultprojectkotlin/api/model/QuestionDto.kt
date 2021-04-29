package de.bornholdtlee.defaultprojectkotlin.api.model

import com.google.gson.annotations.SerializedName

data class QuestionDto(

    @SerializedName("question_id")
    val questionId: String,

    val title: String,
    val link: String
)
