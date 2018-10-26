package com.example.jokot.racyclerviewbinar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initRecyclerView()
        initData()
    }

    private fun initRecyclerView() {
        with(rv_home) {
            adapter = HomeAdapter(items)
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
