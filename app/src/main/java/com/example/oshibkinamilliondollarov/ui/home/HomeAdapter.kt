package com.example.oshibkinamilliondollarov.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.model.ThemeModel
import kotlinx.android.synthetic.main.item_theme.view.*

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    var models = listOf<ThemeModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    var onItemClicked: (id: Int) -> Unit = {}

    override fun getItemCount(): Int = models.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(data: ThemeModel) {
            itemView.tvNameTheme.text = data.name
            itemView.tvDescription.text = data.description

            itemView.setOnClickListener {
                onItemClicked.invoke(data.id)
            }

        }
    }

}