package de.timbo.kartoffel.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeekSuggestionEntity(
    @PrimaryKey
    @ColumnInfo(name = "recipe_ids")
    var recipeIds: List<Int>
//    @ColumnInfo(name = "first_id")
//    var firstRecipeId: Int,
//    @ColumnInfo(name = "second_id")
//    var secondRecipeId: Int,
//    @ColumnInfo(name = "third_id")
//    var thirdRecipeId: Int,
//    @ColumnInfo(name = "fourth_id")
//    var fourthRecipeId: Int,
//    @ColumnInfo(name = "fifth_id")
//    var fifthRecipeId: Int,
//    @ColumnInfo(name = "sixth_id")
//    var sixthRecipeId: Int,
//    @ColumnInfo(name = "seventh_id")
//    var seventhRecipeId: Int,
)