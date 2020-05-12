package com.example.bball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{

            startActivity(Intent(this@MainActivity,BmiJavaActivity::class.java))
        }
        button2.setOnClickListener{

            startActivity(Intent(this@MainActivity,BmiKotlinActivity::class.java))
        }

        button3.setOnClickListener{

            startActivity(Intent(this@MainActivity,VariableJavaActivity::class.java))
        }
        button.setOnClickListener{

            startActivity(Intent(this@MainActivity,VariableKotlinActivity::class.java))
        }

        baseballGame.setOnClickListener{

            startActivity(Intent(this@MainActivity,BaseballGameActivity::class.java))
        }

        button5.setOnClickListener{
            startActivity(Intent(this@MainActivity,ControlJavaActivity::class.java))
        }

        button6.setOnClickListener{
            startActivity(Intent(this@MainActivity,ControlKotlinActivity::class.java))
        }

    }
}
