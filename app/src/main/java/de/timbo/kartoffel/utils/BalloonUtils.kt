package de.timbo.kartoffel.utils

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.skydoves.balloon.*
import de.timbo.kartoffel.R

object BalloonUtils {

    fun getExplainBalloon(context: Context, lifecycleOwner: LifecycleOwner): Balloon {
        return Balloon.Builder(context)
            .setText("Select up to seven categories and see what happens! \nOne thing is certain: \nyou wont be hungry anymore!")
            .setHeight(BalloonSizeSpec.WRAP)
            .setWidth(BalloonSizeSpec.WRAP)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowPosition(0.5f)
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setTextSize(16f)
            .setPadding(8)
            .setCornerRadius(8f)
            .setBackgroundColorResource(R.color.skyBlue)
            .setLifecycleOwner(lifecycleOwner)
            .build()
    }

    fun getEditBalloon(context: Context, lifecycleOwner: LifecycleOwner): Balloon {
        return Balloon.Builder(context)
            .setText("You can edit your profile now!")
            .setArrowSize(10)
            .setWidthRatio(1.0f)
            .setHeight(BalloonSizeSpec.WRAP)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowPosition(0.5f)
            .setPadding(12)
            .setMarginRight(12)
            .setMarginLeft(12)
            .setTextSize(15f)
            .setCornerRadius(8f)
            .setTextColorResource(R.color.white_87)
            .setIconDrawableResource(R.drawable.ic_placeholde)
            .setBackgroundColorResource(R.color.skyBlue)
            .setOnBalloonDismissListener {
                Toast.makeText(context.applicationContext, "dismissed", Toast.LENGTH_SHORT).show()
            }
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setLifecycleOwner(lifecycleOwner)
            .build()
    }

    fun getNavigationBalloon(
        context: Context,
        onBalloonClickListener: OnBalloonClickListener,
        lifecycleOwner: LifecycleOwner
    ): Balloon {
        return Balloon.Builder(context)
            .setText("You can access your profile from on now.")
            .setArrowSize(10)
            .setArrowPosition(0.62f)
            .setWidthRatio(1.0f)
            .setHeight(BalloonSizeSpec.WRAP)
            .setTextSize(15f)
            .setPadding(10)
            .setMarginRight(12)
            .setMarginLeft(12)
            .setCornerRadius(4f)
            .setAlpha(0.9f)
            .setTextColorResource(R.color.white_93)
            .setIconDrawableResource(R.drawable.ic_placeholde)
            .setBackgroundColorResource(R.color.colorPrimary)
            .setOnBalloonClickListener(onBalloonClickListener)
            .setBalloonAnimation(BalloonAnimation.FADE)
            .setLifecycleOwner(lifecycleOwner)
            .build()
    }
}