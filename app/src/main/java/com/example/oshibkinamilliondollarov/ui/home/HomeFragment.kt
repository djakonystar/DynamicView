package com.example.oshibkinamilliondollarov.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.BookDatabase
import com.example.oshibkinamilliondollarov.data.dao.MyDao
import com.example.oshibkinamilliondollarov.data.model.MyData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val adapter = MyAdapter()
    private lateinit var dao: MyDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvThemes.adapter = adapter
        //rvThemes.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        dao = BookDatabase.getInstance(requireContext()).dao()

        setData()
    }

    private fun setData() {
        adapter.models = dao.getAllData()
    }
}