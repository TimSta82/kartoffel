package de.bornholdtlee.defaultprojectkotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.bornholdtlee.defaultprojectkotlin.database.dao.QuestionDao
import de.bornholdtlee.defaultprojectkotlin.database.model.Question

@Database(entities = [Question::class], version = 1)
abstract class QuestionDb : RoomDatabase() {

    abstract fun questionDao(): QuestionDao
}
