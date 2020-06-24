package com.reactions.deathlines.presentation.ui.features.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.reactions.deathlines.presentation.R
import com.reactions.deathlines.presentation.ui.base.BaseActivity
import com.reactions.deathlines.presentation.ui.features.home.HomeFragment
import com.reactions.deathlines.presentation.ui.features.tasks.TasksFragment
import com.reactions.deathlines.presentation.ui.features.upcoming.UpcomingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationView.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val homeFragment = HomeFragment.newInstance()
                    openFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_tasks -> {
                    val tasksFragment = TasksFragment.newInstance()
                    openFragment(tasksFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_upcoming -> {
                    val upcomingFragment = UpcomingFragment.newInstance()
                    openFragment(upcomingFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activityMainHomeHostFragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun getNavControllerId(): Int = R.id.activityMainHomeHostFragment
}