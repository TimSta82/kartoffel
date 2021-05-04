package de.bornholdtlee.defaultprojectkotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ExtendedIngredient(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("aisle")
    val aisle: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("consistency")
    val consistency: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nameClean")
    val nameClean: String?,
    @SerializedName("original")
    val original: String?,
    @SerializedName("originalString")
    val originalString: String?,
    @SerializedName("originalName")
    val originalName: String?,
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("meta")
    val meta: @RawValue List<Any?>?, // TODO ANY?
    @SerializedName("metaInformation")
    val metaInformation: @RawValue List<Any?>?, // TODO ANY?
    @SerializedName("measures")
    val measures: @RawValue Measures?
):Parcelable {
    data class Measures(
        @SerializedName("us")
        val us: Us?,
        @SerializedName("metric")
        val metric: Metric?
    ) {
        data class Us(
            @SerializedName("amount")
            val amount: Double?,
            @SerializedName("unitShort")
            val unitShort: String?,
            @SerializedName("unitLong")
            val unitLong: String?
        )

        data class Metric(
            @SerializedName("amount")
            val amount: Double?,
            @SerializedName("unitShort")
            val unitShort: String?,
            @SerializedName("unitLong")
            val unitLong: String?
        )
    }
}