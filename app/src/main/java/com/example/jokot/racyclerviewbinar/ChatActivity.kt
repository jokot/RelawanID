package com.example.jokot.racyclerviewbinar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        var counter = 0
        val list = mutableListOf<String>()
        ll_1.visibility = View.INVISIBLE
        ll_2.visibility = View.INVISIBLE

        btn_send.setOnClickListener {
            counter++
            list.add(et_tulis.text.toString())
            et_tulis.setText("", TextView.BufferType.EDITABLE)
            when (counter) {
                1 -> {
                    ll_1.visibility = View.VISIBLE
                    tv_msg1.text = list[counter - 1]
                }
                2 -> {
                    ll_2.visibility = View.VISIBLE
                    tv_msg2.text = list[counter - 1]
                }

            }
        }
    }
}
