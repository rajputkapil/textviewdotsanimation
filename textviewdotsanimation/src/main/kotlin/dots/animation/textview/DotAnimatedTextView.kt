package dots.animation.textview

import android.content.Context
import android.os.Handler
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import android.graphics.Rect
import android.widget.LinearLayout


open class DotAnimatedTextView : AppCompatTextView {

    var threadHandler: Handler? = null

    var runnable: Runnable? = null

    var dotsCount: Int = 4 // default is 4 dots count

    var animationDelayTime: Long = 500 // default is 5 ms

    var tempDots: Int = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    /**
     *call to start showing Animation
     */
    fun showDotsAnimation() {
        setWidthToRemoveAnimationLack()
        setText("")
        if (threadHandler == null && runnable == null) {
            threadHandler = Handler()
            runnable = object : Runnable {
                override fun run() {

                    threadHandler?.postDelayed(this, animationDelayTime)
                    if (tempDots == dotsCount) {
                        tempDots = 0
                        setText("")
                    } else {
                        setText(getDot(++tempDots))
                    }
                    invalidate()
                }
            }
            runnable!!.run()
        }
    }

    /**
     *Simple hack to overcome layout vibration
     */
    fun setWidthToRemoveAnimationLack() {
        visibility = View.INVISIBLE
        setText(getDot(dotsCount))
        val bounds = Rect()
        val textPaint = this.getPaint()
        textPaint.getTextBounds(getDot(dotsCount), 0, this.length(), bounds)
        val width = bounds.width() + 100
        val params = LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT)
        this.layoutParams = params
        visibility = View.VISIBLE
    }

    /**
     *logic to set dots according to dots count
     */
    fun getDot(dotNo: Int): String {
        val sb = StringBuilder()
        for (i in 1..dotNo) {
            sb.append(".")
        }
        return sb.toString()
    }

    fun stopAnimation() {
        threadHandler?.removeCallbacks(runnable)
    }

    fun noOfDots(dotsCount: Int) {
        this.dotsCount = dotsCount
    }

    fun animationDelay(animationDelayTime: Long) {
        this.animationDelayTime = animationDelayTime
    }
}
