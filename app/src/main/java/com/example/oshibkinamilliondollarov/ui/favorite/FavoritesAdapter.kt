package com.example.oshibkinamilliondollarov.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.model.ThemeModel
import kotlinx.android.synthetic.main.item_favorite.view.*

class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    var models = listOf<ThemeModel>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    var onItemClicked: (id: Int) -> Unit = {}

    override fun getItemCount(): Int = models.size

    inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun populateModel(model: ThemeModel) {
            itemView.nameTheme.text = model.name
            itemView.description.text = model.description
            itemView.setOnClickListener {
                onItemClicked.invoke(model.id)
            }
        }
    }
}

