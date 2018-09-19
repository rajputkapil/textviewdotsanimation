package ontext.simple.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import dots.animation.textview.DotAnimatedTextView
import dots.animation.textview.TextAndAnimationView

class MainActivity : AppCompatActivity() {

    internal lateinit var textAndAnimationView: TextAndAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textAndAnimationView = findViewById(R.id.animated_dots)
    //    textAndAnimationView.setText("Loading")
    //    textAndAnimationView.setTextSize(30f)
    }

    override fun onStop() {
        super.onStop()
        textAndAnimationView.stopAnimation()
    }
}
