package com.mashup.torchlight.adapter

import android.util.SparseArray
import androidx.core.util.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mashup.torchlight.ui.signup.*

class SignUpFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val movePageListener: SignUpActivity.ISignUpMovePageListener
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            POS_SIGNUP_EMAIL_INPUT -> SignUpEmailInputFragment.newInstance(movePageListener)
            POS_SIGNUP_EMAIL_AUTH -> SignUpEmailAuthFragment.newInstance(movePageListener)
            POS_SIGNUP_EMAIL_USERINFO -> SignUpUserInfoFragment.newInstance(movePageListener)
            POS_SIGNUP_EMAIL_SUCCESS -> SignUpSuccessFragment.newInstance(movePageListener)

            else -> SignUpEmailInputFragment.newInstance(movePageListener)  // bullshit. just return anything
        }
    }

    companion object {
        private const val POS_SIGNUP_EMAIL_INPUT = 0
        private const val POS_SIGNUP_EMAIL_AUTH = 1
        private const val POS_SIGNUP_EMAIL_USERINFO = 2
        private const val POS_SIGNUP_EMAIL_SUCCESS = 3
    }
}