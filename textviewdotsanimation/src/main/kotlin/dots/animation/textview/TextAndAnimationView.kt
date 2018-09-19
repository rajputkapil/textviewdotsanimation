package dots.animation.textview

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.widget.LinearLayout


class TextAndAnimationView : LinearLayout {

    lateinit var textToShow: TextView
    lateinit var animatedTextView: DotAnimatedTextView

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        showTextAndAnimation(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        showTextAndAnimation(context, attrs)
    }

    /**
     * Call this method to start showing animation of dots
     * @param context: activity Context to pass
     * @param attrs: attribute set
     *
     */
    private fun showTextAndAnimation(context: Context, attrs: AttributeSet) {

        inflate(context, R.layout.layout, this)

        textToShow = this.findViewById(R.id.text_to_show)
        animatedTextView = this.findViewById(R.id.progress_dots_txt)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.TextAndAnimationView, 0, 0)
        try {
            val text = ta.getText(R.styleable.TextAndAnimationView_setText)
            val textHint = ta.getText(R.styleable.TextAndAnimationView_setTextHint)
            val color = ta.getInt(R.styleable.TextAndAnimationView_setTextColor, 0)
            val textSize = ta.getFloat(R.styleable.TextAndAnimationView_setTextSize, 0f)
            val dotsCount = ta.getInt(R.styleable.TextAndAnimationView_numberOfDots, 0)
            if (text != null)
                setText(text)
            if (textHint != null)
                setTextHint(textHint)
            if (color != 0)
                setTextColor(color)
            if (textSize != 0f)
                setTextSize(textSize)
            if (dotsCount != 0)
                noOfDots(dotsCount)
        } finally {
            ta.recycle()
        }

        animatedTextView.showDotsAnimation()
    }

    /**
     *
     */
    /**
     *Shows text like loading
     */
    fun setText(text: CharSequence) {
        textToShow.setText(text)
    }

    /**
     *text size
     */
    fun setTextSize(size: Float) {
        textToShow.setTextSize(size)
        animatedTextView.setTextSize(size)
    }

    /**
     *text hint
     */
    fun setTextHint(textHint: CharSequence) {
        textToShow.setHint(textHint)
    }

    /**
     *text color
     */
    fun setTextColor(color: Int) {
        textToShow.setTextColor(color)
        animatedTextView.setTextColor(color)
    }

    /**
     *Remember to call this when activity stops, to stop handler
     */
    fun stopAnimation() {
        animatedTextView.stopAnimation()
    }

    /**
     *Animated dots count
     */
    fun noOfDots(dotsCount: Int) {
        animatedTextView.noOfDots(dotsCount)
    }

    /**
     *delay in animation dots, define in ms
     */
    fun animationDelay(animationDelayTime: Long) {
        animatedTextView.animationDelay(animationDelayTime)
    }
}
