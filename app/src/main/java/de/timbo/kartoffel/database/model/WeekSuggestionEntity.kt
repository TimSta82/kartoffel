package de.timbo.kartoffel.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeekSuggestionEntity(
    @PrimaryKey
    @ColumnInfo(name = "week_id")
    var weekId: Int,
    @ColumnInfo(name = "recipe_ids")
    var recipeIds: List<Int>
)
