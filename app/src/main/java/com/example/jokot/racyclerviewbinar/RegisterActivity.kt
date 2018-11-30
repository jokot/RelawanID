package com.example.jokot.racyclerviewbinar

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_registration.setOnClickListener {
            val editor = getSharedPreferences(HomeActivity.MY_PREV_NAME, Context.MODE_PRIVATE).edit()
            val pref = getSharedPreferences(HomeActivity.MY_PREV_NAME, Context.MODE_PRIVATE)

            val counter = pref.getInt("user", 0)

            editor.putInt("user", counter + 1)
            editor.apply()

//            var id = 0
            var notExist = true
            var i = 0
            while (i <= counter) {
                val emailRegistered = pref.getString("email$i", "tidak ada")

                if (email.text.toString() == emailRegistered) {
                    notExist = false
                    break
                } else {
                    i++
                }
            }
            if (notExist) {
                editor.putString("fullName$counter", name.text.toString())
                editor.apply()
                editor.putString("noHp$counter", noHp.text.toString())
                editor.apply()
                editor.putString("noKtp$counter", noKtp.text.toString())
                editor.apply()
                editor.putString("tglLahir$counter", tgllahir.text.toString())
                editor.apply()
                editor.putString("alamatKtp$counter", address.text.toString())
                editor.apply()
                editor.putString("domisili$counter", domisili.text.toString())
                editor.apply()
                editor.putString("email$counter", email.text.toString())
                editor.apply()
                editor.putString("password$counter", password.text.toString())
                editor.apply()
                editor.putString("confirmPass$counter", confirmPassword.text.toString())
                editor.apply()
                finish()
            } else {
                Toast.makeText(this, "Email already registered", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
