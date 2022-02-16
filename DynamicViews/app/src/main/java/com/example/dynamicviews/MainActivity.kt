package com.example.dynamicviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutMain = findViewById<LinearLayout>(R.id.layout_main)



        layoutMain.addView(makeTxtView("Email"))
        layoutMain.addView(makeEdtView("Email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS))
        layoutMain.addView(makeTxtView("Password"))
        layoutMain.addView(makeEdtView("Password", InputType.TYPE_TEXT_VARIATION_PASSWORD))
    }

    fun makeTxtView(message: String = "new textview"): TextView {

        val textView = TextView(this)

        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.text = message
        textView.setTextColor(AppCompatResources.getColorStateList(this, R.color.purple))
        textView.textSize = 25F

        return textView
    }

    fun makeEdtView(hint: String = "new edt", inputType: Int = InputType.TYPE_CLASS_TEXT): TextView {

        val edt = EditText(this)

        edt.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        edt.hint = hint
        edt.setTextColor(AppCompatResources.getColorStateList(this, R.color.purple))
        edt.textSize = 25F
        edt.inputType = InputType.TYPE_CLASS_TEXT or inputType

        return edt
    }
}