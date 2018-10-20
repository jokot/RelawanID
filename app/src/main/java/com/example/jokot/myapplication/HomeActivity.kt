package com.example.jokot.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private val homeAdapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setData()
        initRecyclerView()
    }

    private fun initRecyclerView(){
        with(rv_home){
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
        }
    }

    private fun setData() {
        val data = listOf("Banyuwangi", "Surabaya", "Klaten", "Tegal", "Semarang")
        homeAdapter.update(data)
    }
}
