package com.ashique.mycalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.IllegalArgumentException


class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculato_constraint)

        val Display : TextView = findViewById(R.id.tvDisplay)
        val BtnC: ImageButton = findViewById(R.id.btnC)
        val BtnDel: ImageButton = findViewById(R.id.btnDel)
        val BtnPercentage: Button = findViewById(R.id.btnPercentage)
        val BtnDivide: ImageButton = findViewById(R.id.btnDivide)
        val BtnMul: ImageButton = findViewById(R.id.btnMultiplication)
        val BtnSub: ImageButton = findViewById(R.id.btnSubtract)
        val BtnAdd: ImageButton = findViewById(R.id.btnAdd)
        val BtnDot: Button = findViewById(R.id.btnDot)
        val BtnEqual: ImageButton = findViewById(R.id.btnEqual)


        BtnDel.setOnClickListener { view->
            var current = Display.text.toString().trim()
            if(current.length == 1){
                Display.setText("0")
            }
            else{
                current = current.dropLast(1)
                Display.setText(current)
            }
        }
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

        BtnC.setOnClickListener() { view->
            Display.setText("0")
        }
        setButtonClick(BtnPercentage,"%",Display)
        setButtonClick(BtnAdd,"+",Display)
        setButtonClick(BtnSub,"-",Display)
        setButtonClick(BtnDot,".",Display)
        setButtonClick(BtnMul,"*",Display)
        setButtonClick(BtnDivide,"/",Display)



        BtnEqual.setOnClickListener{ view->
            var value = Display.text.toString()
            var result : Double = 0.0
            try{
                result = ExpressionBuilder(value).build().evaluate()
                Display.setText(result.toString())

            }
            catch (e: IllegalArgumentException){
                Log.d("hello","cul house")
                Toast.makeText(
                    this@Calculator,
                    "You have given wrong expression",
                    Toast.LENGTH_SHORT
                ).show()
            }catch(e: ArithmeticException){
                Log.d("hello","cul house")
                Toast.makeText(
                    this@Calculator,
                    "You have given wrong expression",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }


    }

    private fun setButtonClick(button: Button, value: String, Display : TextView) {
        button.setOnClickListener {
            val current = Display.text.toString().trim()
            if(current == "0"){
                Display.setText(value)
            }
            else{
                Display.setText(current + value)
            }
        }
    }
    private fun setButtonClick(button: ImageButton, value: String, Display : TextView) {
        button.setOnClickListener {
            val current = Display.text.toString().trim()
            if(current == "0"){
                Display.setText(value)
            }
            else{
                Display.setText(current + value)
            }
        }
    }
}