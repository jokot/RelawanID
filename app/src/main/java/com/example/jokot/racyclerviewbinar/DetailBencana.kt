package com.example.jokot.racyclerviewbinar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_bencana.*
import kotlinx.android.synthetic.main.activity_register.*

class DetailBencana : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_bencana)

        btn_chat.setOnClickListener {
            val intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }
    }
}
