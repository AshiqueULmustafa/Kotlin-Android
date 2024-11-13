package com.ashique.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val Display : TextView = findViewById(R.id.tvDisplay)
        val BtnC: ImageButton = findViewById(R.id.btnC)
        val BtnDel: ImageButton = findViewById(R.id.btnDel)
        val BtnPercentage: Button = findViewById(R.id.btnPercentage)
        val BtnDivide: ImageButton = findViewById(R.id.btnDivide)
        val BtnMul: ImageButton = findViewById(R.id.btnMultiplication)
        val BtnSub: ImageButton = findViewById(R.id.btnSubtract)
        val BtnAdd: ImageButton = findViewById(R.id.btnAdd)
        val BtnDot: Button = findViewById(R.id.btnDot)


        val buttonIds = arrayOf(
            R.id.btnZero,R.id.btnOne, R.id.btnTwo, R.id.btnThree,
            R.id.btnFour, R.id.btnFive, R.id.btnSix,
            R.id.btnSeven, R.id.btnEight, R.id.btnNine
        )

        val Buttons = buttonIds.map{ findViewById<Button>(it) }

        Buttons.forEachIndexed { index, button ->
            button.setOnClickListener { view->
                val current = Display.text.toString().trim()
                val value = index.toString()
                if(current == "0"){
                    Display.setText(value)
                }
                else{
                    Display.setText(current + value)
                }

            }
        }

        BtnC.setOnClickListener(){ view->
            Display.setText("0")
        }

    }
}