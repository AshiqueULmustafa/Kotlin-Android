package com.ashique.signuppage


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class SignUpPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val etfname = findViewById<EditText>(R.id.etFname)
        val tvfname = findViewById<TextView>(R.id.missfname)
        val etlname = findViewById<EditText>(R.id.etLname)
        val tvlname = findViewById<TextView>(R.id.misslname)
        val etdob = findViewById<EditText>(R.id.etDOB)
        val tvdob = findViewById<TextView>(R.id.missdob)
        val etemail = findViewById<EditText>(R.id.etEmail)
        val tvemail = findViewById<TextView>(R.id.missemail)
        val etaddress = findViewById<EditText>(R.id.etAddress)
        val tvaddress = findViewById<TextView>(R.id.missaddress)
        val etpassword = findViewById<EditText>(R.id.etPass)
        val tvpass = findViewById<TextView>(R.id.misspass)
        val etphone = findViewById<EditText>(R.id.etPhone)
        val tvphone = findViewById<TextView>(R.id.missphone)
        val etconfirmPass = findViewById<EditText>(R.id.etCpass)
        val tvcpass = findViewById<TextView>(R.id.misscpass)
        val tvmissmatch = findViewById<TextView>(R.id.missmatchpass)
        val btnsubmit: Button = findViewById(R.id.btnSubmit)
        val badPass: TextView = findViewById(R.id.tvBadPass)

        val fields = mapOf(
                etfname to tvfname,
                etlname to tvlname,
                etdob to tvdob,
                etaddress to tvaddress,
                etemail to tvemail,
                etphone to tvphone,
                etpassword to tvpass,
                etconfirmPass to tvcpass
            )
        fields.forEach{ (editText, textview)->
            editText.onFocusChangeListener = View.OnFocusChangeListener{ _,hasFocus ->
                if(hasFocus){
                    textview.visibility = View.GONE
                }
            }
        }


        etpassword.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->

            if (hasFocus) {
                badPass.visibility = View.VISIBLE
                etpassword.addTextChangedListener{
                    val fieldvalue = etpassword.text.toString().trim()
                    if(fieldvalue.length<8){
                        badPass.visibility = View.VISIBLE
                    }
                    else{
                        badPass.visibility = View.GONE
                    }
                }
                tvpass.visibility = View.GONE
            } else {
                badPass.visibility = View.GONE
            }
        }


        btnsubmit.setOnClickListener {
            val password = etpassword.text.toString().trim()
            val confirmpass = etconfirmPass.text.toString().trim()

            fields.forEach{ (editText, textview)->

                editText.clearFocus()
                val fieldvalue = editText.text.toString().trim()
                if(fieldvalue.isEmpty()){
                    textview.visibility = View.VISIBLE
                }
                else {
                    textview.visibility = View.GONE
                }

            }

            if (password.isEmpty()) {
                tvpass.visibility = View.VISIBLE
            }
            else if(password.length < 8){
                badPass.visibility = View.VISIBLE
                tvpass.visibility = View.GONE
                tvcpass.visibility = View.GONE
                tvmissmatch.visibility = View.GONE
            }
            else if (confirmpass.isEmpty()) {
                badPass.visibility = View.GONE
                tvpass.visibility = View.GONE
                tvcpass.visibility = View.VISIBLE
            } else if (password != confirmpass) {
                tvpass.visibility = View.GONE
                tvmissmatch.visibility = View.VISIBLE
            } else {
                tvpass.visibility = View.GONE
                tvmissmatch.visibility = View.GONE
            }

        }


    }
}