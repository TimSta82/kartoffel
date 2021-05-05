package de.timbo.kartoffel.ui.balloons

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.skydoves.balloon.*
import de.timbo.kartoffel.R

class ExplainBalloonFactory : Balloon.Factory() {
    override fun create(context: Context, lifecycle: LifecycleOwner?): Balloon {
        return createBalloon(context) {
            setText("Select up to seven categories and see what happens! \nOne thing is certain: \nyou wont be hungry anymore!")
            setHeight(BalloonSizeSpec.WRAP)
            setWidth(BalloonSizeSpec.WRAP)
            setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            setArrowPosition(0.5f)
            setBalloonAnimation(BalloonAnimation.ELASTIC)
            setTextSize(16f)
            setPadding(8)
            setCornerRadius(8f)
            setBackgroundColorResource(R.color.skyBlue)
            setLifecycleOwner(lifecycleOwner)
            build()
        }
    }
}