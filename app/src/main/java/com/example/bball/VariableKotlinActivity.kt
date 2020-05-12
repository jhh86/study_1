package com.example.bball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_variable.*
import java.text.SimpleDateFormat
import java.util.*

class VariableKotlinActivity : AppCompatActivity() {

    var clickCount = 0;
    val startTime = System.currentTimeMillis();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_variable)

        var timeText = SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime)

        startTimeLabel.text =  "시작시간 : ${timeText}"

        clickCountLable.text = "클릭 획수 : ${clickCount}"

        button.setOnClickListener{
            clickCount = clickCount + 1
            clickCountLable.text = "클릭 횟수 : ${clickCount}"

        }
    }
}
