package de.timbo.kartoffel.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.timbo.kartoffel.database.dao.RecipeDao
import de.timbo.kartoffel.database.dao.WeekSuggestionDao
import de.timbo.kartoffel.database.model.RecipeEntity
import de.timbo.kartoffel.database.model.WeekSuggestionEntity

@Database(entities = [RecipeEntity::class, WeekSuggestionEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class RecipeDb : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
    abstract fun weekSuggestionDao(): WeekSuggestionDao
}