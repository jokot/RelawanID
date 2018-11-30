package com.example.jokot.racyclerviewbinar

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val pref = getSharedPreferences(HomeActivity.MY_PREV_NAME, Context.MODE_PRIVATE)

        val id = pref.getInt("id",0)

        name.text = pref.getString("fullName$id","Anonim")
        noHp.text = pref.getString("noHp$id","Anonim")
        noKtp.text = pref.getString("noKtp$id","Anonim")
        tgllahir.text = pref.getString("tglLahir$id","Anonim")
        address.text = pref.getString("alamatKtp$id","Anonim")
        domisili.text = pref.getString("domisili$id","Anonim")
        email.text = pref.getString("email$id","Anonim")

    }
}
