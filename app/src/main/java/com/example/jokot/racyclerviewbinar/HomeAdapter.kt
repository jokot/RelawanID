package com.example.jokot.racyclerviewbinar

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder.view.*

class HomeAdapter(private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var data = listOf<String>()

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(LayoutInflater.from(group.context).inflate(R.layout.view_holder, group, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as HomeViewHolder
//        viewHolder.textNama.text = items[position]
        viewHolder.bindItem(items[position])


    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textNama = view.tv_nama_bencana
        val textDate = view.tv_date_bencana

        fun bindItem(items: Item) {

            textNama.text = items.name
            textDate.text = items.date
            Glide.with(itemView.context).load(items.image).into(itemView.img_bencana)

        }
    }

//    fun update(data: List<String>) {
//        this.data = data
//        notifyDataSetChanged()
//    }
}