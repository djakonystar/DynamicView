package com.example.oshibkinamilliondollarov.ui.detail

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.BookDatabase
import com.example.oshibkinamilliondollarov.data.dao.BookDao
import com.example.oshibkinamilliondollarov.data.model.ThemeModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val TEXTS_ID = "textsId"
    }

    private var themeId: Int = 0
    private lateinit var dao: BookDao
    private lateinit var themeModel: ThemeModel
    private var menuItem: MenuItem? = null
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("MySharedPreferences", Activity.MODE_PRIVATE)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        themeId = intent.getIntExtra(TEXTS_ID, 1)
        dao = BookDatabase.getInstance(this).dao()
        themeModel = dao.getTextByThemeId(themeId)
        themeModel.text?.let {
            val linearLayout = LinearLayout(this)
            val scrollView = ScrollView(this)
            linearLayout.orientation = LinearLayout.VERTICAL
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val divider = TextImageDivider()
            val divided = divider.divideTextAndImage(it)
            for (i in 0 until divided.texts.size) {
                val webView = WebView(this)
                webView.loadData(divided.texts[i], "text/html", "UTF-8")
                webView.settings.defaultFontSize = pref.getFloat("textSize", 16f).toInt()
                linearLayout.addView(webView)
                if (divided.images.size > i) {
                    val imageView = ImageView(this)
                    val resId = resources.getIdentifier(
                        divided.images[i],
                        "drawable",
                        packageName
                    )
                    imageView.setImageResource(resId)
                    linearLayout.addView(imageView)
                }
            }
            scrollView.addView(linearLayout)
            setContentView(scrollView)
        }
        supportActionBar?.title = themeModel.name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu?.findItem(R.id.item_bookmark)
        setFavoriteIcon()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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

    private fun setFavoriteIcon() {
        if (themeModel.isFavorite == 1) {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }
}