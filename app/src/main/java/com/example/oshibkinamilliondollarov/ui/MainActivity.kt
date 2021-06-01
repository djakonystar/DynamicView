package com.example.oshibkinamilliondollarov.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val TYPE_ID = "typeId"
        const val HOME = 1
        const val REVIEWS = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        val fragment = HomeFragment()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, HOME)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
        navView.setNavigationItemSelectedListener {
            val mFragment = HomeFragment()
            val mBundle = Bundle()
            when(it.itemId) {
                R.id.nav_home -> {
                    mBundle.putInt(TYPE_ID, HOME)
                    mFragment.arguments = mBundle
                }
                R.id.nav_reviews -> {
                    mBundle.putInt(TYPE_ID, REVIEWS)
                    mFragment.arguments = mBundle
                }
                R.id.nav_about_us -> {
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_favorites -> {
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_share -> {
                    return@setNavigationItemSelectedListener true
                }
                else -> return@setNavigationItemSelectedListener false
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, mFragment).commit()
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}