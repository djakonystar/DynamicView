package com.example.oshibkinamilliondollarov.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.BookDatabase
import com.example.oshibkinamilliondollarov.data.dao.BookDao
import com.example.oshibkinamilliondollarov.data.model.ThemeModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val TEXTS_ID = "textsId"

    }
    private var themeId: Int = 0
    private lateinit var dao: BookDao
    private lateinit var themeModel: ThemeModel
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        themeId = intent.getIntExtra(TEXTS_ID, 1)
        dao = BookDatabase.getInstance(this).dao()
        themeModel = dao.getTextByThemeId(themeId)
        themeModel.text?.let {
            webView.loadData(it, "text/html", "UTF-8")
        }

        themeModel = dao.getTextByThemeId(themeId)
        supportActionBar?.title = themeModel.name

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu?.findItem(R.id.item_bookmark)
        setFavoriteIcon()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            R.id.item_bookmark -> setFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavorite() {
        if (themeModel.isFavorite == 0) themeModel.isFavorite = 1
        else themeModel.isFavorite = 1 - themeModel.isFavorite
        setFavoriteIcon()
        dao.updateTheme(themeModel)
    }

    private fun setFavoriteIcon () {
        if (themeModel.isFavorite == 1){
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }

}