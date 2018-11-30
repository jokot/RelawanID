package com.example.jokot.racyclerviewbinar

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_register.*

class HomeActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    companion object {
        val MY_PREV_NAME= "myShared"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val pref = getSharedPreferences(HomeActivity.MY_PREV_NAME, Context.MODE_PRIVATE)
        val id = pref.getInt("id",0)

        tv_nama.text = pref.getString("fullName$id","Anonim")

        constrain.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

        initRecyclerView()
        initData()
    }

    private fun initRecyclerView() {
        with(rv_home) {
            adapter = HomeAdapter(items){
                val intent = Intent(this@HomeActivity,DetailBencana::class.java)
                context.startActivity(intent)
            }
            layoutManager = LinearLayoutManager(this@HomeActivity)
        }
    }

//    private fun setData() {
//        val data = listOf("Badai - Kalimantan Sekatan","Kelaparan - FMIPA UGM", "Gempa - Lombok", "Tsunami - Palu")
//        homeAdapter.update(data)
//    }

    private fun initData(){
        val name = resources.getStringArray(R.array.nama_bencana_dan_tempat)
        val desc = resources.getStringArray(R.array.bencan_date)
        val image = resources.obtainTypedArray(R.array.bencana_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0), desc[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}
