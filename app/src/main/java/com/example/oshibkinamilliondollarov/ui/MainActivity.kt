package com.example.oshibkinamilliondollarov.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.ui.favorite.FavoritesFragment
import com.example.oshibkinamilliondollarov.ui.home.HomeFragment
import com.example.oshibkinamilliondollarov.ui.reviews.ReviewsFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val chapter_id = "chapter_id"
        const val home = 1
        const val isFavorite = 2
        const val reviews = 3
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
        bundle.putInt(chapter_id, 1)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
        navView.setNavigationItemSelectedListener {
            val mFragment = HomeFragment()
            val mBundle = Bundle()
            mFragment.arguments = mBundle
            when(it.itemId) {
                R.id.nav_home -> {
                    mBundle.putInt(chapter_id, 1)
                    mFragment.arguments = mBundle
                }
                R.id.nav_reviews -> {
                    mBundle.putInt(chapter_id, 3)
                    val rfragment = ReviewsFragment()
                    rfragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, rfragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_about_us -> {
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_favorites -> {
                    mBundle.putInt(chapter_id, 2)
                    val fragment = FavoritesFragment()
                    fragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
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

}