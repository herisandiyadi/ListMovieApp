@file:Suppress("DEPRECATION")

package com.herisand.submissionjp.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.herisand.submissionjp.R
import com.herisand.submissionjp.ui.movie.MovieFragment
import com.herisand.submissionjp.ui.tvshows.TvShowsFragment

@Suppress("DEPRECATION")
class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

   companion object{
       private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvshows)
   }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TvShowsFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])
}