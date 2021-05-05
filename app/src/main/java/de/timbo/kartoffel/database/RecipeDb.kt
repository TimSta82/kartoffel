package de.bornholdtlee.defaultprojectkotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.bornholdtlee.defaultprojectkotlin.database.dao.RecipeDao
import de.bornholdtlee.defaultprojectkotlin.database.model.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class RecipeDb : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}