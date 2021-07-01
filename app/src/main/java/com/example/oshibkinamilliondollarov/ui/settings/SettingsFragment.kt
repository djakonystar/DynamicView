package com.example.oshibkinamilliondollarov.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.oshibkinamilliondollarov.R
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment(R.layout.settings_fragment) {

    private lateinit var settings : Settings
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settings = Settings(this.requireContext())
        setTextSize()
        increase.setOnClickListener {
            if (settings.textSize < 30f) {
                settings.textSize = settings.textSize + 2f
                setTextSize()
            }
        }
        decrease.setOnClickListener {
            if (settings.textSize > 16f) {
                settings.textSize = settings.textSize - 2f
                setTextSize()
            }
        }
    }
    private fun setTextSize() {
        tvLorem.textSize = settings.textSize
    }
}