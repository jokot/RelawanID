package com.example.jokot.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_view.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){
    private var data = listOf<String>()

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(group.context).inflate(R.layout.item_view, group, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.namaTempat.text = data[position]
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaTempat = view.tv_nama_bencana
    }

    fun update(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }
}
