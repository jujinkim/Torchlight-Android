package com.mashup.torchlight.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mashup.torchlight.ui.home.HomeFragment
import com.mashup.torchlight.ui.myproject.MyProjectFragment
import com.mashup.torchlight.ui.notifications.NotificationsFragment

class MainFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            MinaScreen.HOME.pos -> HomeFragment.newInstance()
            MinaScreen.MY_PROJECT.pos -> MyProjectFragment.newInstance()
            MinaScreen.NOTIFICATION.pos -> NotificationsFragment.newInstance()

            //TODO jujin : change my page fragment
            MinaScreen.MY_PAGE.pos -> HomeFragment.newInstance()

            else -> HomeFragment.newInstance()
        }
    }

    override fun getItemCount() = 4

    enum class MinaScreen(val pos: Int) {
        HOME(0), MY_PROJECT(1), NOTIFICATION(2), MY_PAGE(3)
    }
}