package com.mashup.torchlight.adapter

import android.util.SparseArray
import androidx.core.util.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mashup.torchlight.ui.signup.SignUpEmailAuthFragment
import com.mashup.torchlight.ui.signup.SignUpEmailInputFragment
import com.mashup.torchlight.ui.signup.SignUpSuccessFragment
import com.mashup.torchlight.ui.signup.SignUpUserInfoFragment

class SignUpFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragmentList = SparseArray<Fragment>();

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            POS_SIGNUP_EMAIL_INPUT -> SignUpEmailInputFragment.newInstance()
            POS_SIGNUP_EMAIL_AUTH -> SignUpEmailAuthFragment.newInstance()
            POS_SIGNUP_EMAIL_USERINFO -> SignUpUserInfoFragment.newInstance()
            POS_SIGNUP_EMAIL_SUCCESS -> SignUpSuccessFragment.newInstance()

            else -> SignUpEmailInputFragment.newInstance()  // bullshit. just return anything
        }
    }

    companion object {
        private const val POS_SIGNUP_EMAIL_INPUT = 0
        private const val POS_SIGNUP_EMAIL_AUTH = 1
        private const val POS_SIGNUP_EMAIL_USERINFO = 2
        private const val POS_SIGNUP_EMAIL_SUCCESS = 3
    }
}