package com.herisand.submissionjp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.herisand.submissionjp.R
import com.herisand.submissionjp.databinding.ActivityMainBinding
import com.herisand.submissionjp.ui.favorite.FavoriteActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        supportActionBar?.title = resources.getString(R.string.home)
        supportActionBar?.elevation = 0f

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityMainBinding.viewPager.adapter = sectionPagerAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.btn_fav_menu) {
            val mIntent = Intent(this, FavoriteActivity::class.java)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}