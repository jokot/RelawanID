package com.example.jokot.racyclerviewbinar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_masuk.setOnClickListener {
            val editor = getSharedPreferences(HomeActivity.MY_PREV_NAME, Context.MODE_PRIVATE).edit()
            val pref = getSharedPreferences(HomeActivity.MY_PREV_NAME, Context.MODE_PRIVATE)
            val counter = pref.getInt("user", 0)

            if (counter == 0) {
                Toast.makeText(this, "$counter", Toast.LENGTH_SHORT).show()
            }

            val email = et_email.text
            val password = et_password.text

            var bool = false
            var i = 0
            while (i <= counter) {
                val emailregistered = pref.getString("email$i", "tidak ada")
                val passwordRegistered = pref.getString("password$i", "tidak ada")
                if (email.toString() == emailregistered &&
                    password.toString() == passwordRegistered
                ) {
                    bool = true
                    editor.putInt("id",i)
                    editor.apply()
                    break
                } else {
                    i++
                }
            }

            if (bool) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Email or Password not Correct",Toast.LENGTH_SHORT).show()
            }
        }

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

