package com.example.oshibkinamilliondollarov.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.BookDatabase
import com.example.oshibkinamilliondollarov.data.dao.BookDao
import com.example.oshibkinamilliondollarov.ui.MainActivity
import com.example.oshibkinamilliondollarov.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val myAdapter = HomeAdapter()
    private lateinit var dao: BookDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvThemes.adapter = myAdapter
        dao = BookDatabase.getInstance(requireContext()).dao()
        myAdapter.onItemClicked = {
            val mIntent = Intent(requireActivity(), DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.TEXTS_ID, it)
            startActivity(mIntent)
        }
        setData()
    }

    private fun setData() {
        myAdapter.models = dao.getAllData()
    }
}