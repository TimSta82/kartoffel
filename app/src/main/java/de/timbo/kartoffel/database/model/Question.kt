package de.timbo.kartoffel.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(

    @PrimaryKey
    @ColumnInfo(name = "question_id")
    var questionId: String,

    var title: String,
    var link: String
)
