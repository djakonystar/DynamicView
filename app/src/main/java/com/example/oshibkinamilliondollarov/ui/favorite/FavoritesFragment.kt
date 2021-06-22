package com.example.oshibkinamilliondollarov.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.BookDatabase
import com.example.oshibkinamilliondollarov.data.dao.BookDao
import com.example.oshibkinamilliondollarov.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.favorites_fragment.*

class FavoritesFragment : Fragment(R.layout.favorites_fragment) {

    private val myAdapter = FavoritesAdapter()
    private lateinit var dao: BookDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFavorites.adapter = myAdapter
        dao = BookDatabase.getInstance(requireContext()).dao()
        myAdapter.onItemClicked = {
            val mIntent = Intent(requireActivity(), DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.TEXTS_ID, it)
            startActivity(mIntent)
        }
    }
    override fun onStart() {
        super.onStart()
        setModel()
    }
    private fun setModel() {
        myAdapter.models = dao.getFavoriteThemes()
    }
}