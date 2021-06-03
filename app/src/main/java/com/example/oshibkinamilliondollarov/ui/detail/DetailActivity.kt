package com.example.oshibkinamilliondollarov.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.text.HtmlCompat
import com.example.oshibkinamilliondollarov.R
import com.example.oshibkinamilliondollarov.data.BookDatabase
import com.example.oshibkinamilliondollarov.data.model.Content
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val TEXTS_ID = "textsId"
    }
    private var themeId: Int = 0
    private lateinit var content: Content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Details")
        themeId = intent.getIntExtra(TEXTS_ID, 1)
        val dao = BookDatabase.getInstance(this).dao()
        content = dao.getTextByThemeId(themeId)
        content.text?.let {
            tvThemeText.text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            R.id.item_bookmark -> return true
        }
        return super.onOptionsItemSelected(item)
    }
}