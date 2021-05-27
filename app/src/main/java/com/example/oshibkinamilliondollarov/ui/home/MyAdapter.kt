package com.example.oshibkinamilliondollarov.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.model.MyData
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var models = listOf<MyData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(data: MyData) {
            itemView.tvNameTheme.text = data.name
            itemView.tvDescription.text = data.description

            itemView.tvNameTheme.setOnClickListener {

            }
        }
    }

}