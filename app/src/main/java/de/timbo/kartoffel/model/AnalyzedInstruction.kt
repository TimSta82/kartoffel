package de.bornholdtlee.defaultprojectkotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class AnalyzedInstruction(
    @SerializedName("name")
    val name: String?,
    @SerializedName("steps")
    val steps: @RawValue List<Step?>?
) : Parcelable {
    data class Step(
        @SerializedName("number")
        val number: Int?,
        @SerializedName("step")
        val step: String?,
        @SerializedName("ingredients")
        val ingredients: List<Ingredient?>?,
        @SerializedName("equipment")
        val equipment: List<Equipment?>?,
        @SerializedName("length")
        val length: Length?
    ) {
        data class Ingredient(
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("localizedName")
            val localizedName: String?,
            @SerializedName("image")
            val image: String?
        )

        data class Equipment(
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("localizedName")
            val localizedName: String?,
            @SerializedName("image")
            val image: String?
        )

        data class Length(
            @SerializedName("number")
            val number: Int?,
            @SerializedName("unit")
            val unit: String?
        )
    }
}
