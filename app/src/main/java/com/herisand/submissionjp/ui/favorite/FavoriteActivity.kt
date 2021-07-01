package com.herisand.submissionjp.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.herisand.submissionjp.R
import com.herisand.submissionjp.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        supportActionBar?.title = resources.getString(R.string.favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val sectionPagerFavAdapter = SectionPagerFavAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPagerFav.adapter = sectionPagerFavAdapter
        activityFavoriteBinding.tabsFav.setupWithViewPager(activityFavoriteBinding.viewPagerFav)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}