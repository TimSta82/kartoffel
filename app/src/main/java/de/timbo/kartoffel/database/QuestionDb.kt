package de.timbo.kartoffel.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.timbo.kartoffel.database.dao.QuestionDao
import de.timbo.kartoffel.database.model.Question

@Database(entities = [Question::class], version = 1)
abstract class QuestionDb : RoomDatabase() {

    abstract fun questionDao(): QuestionDao
}
