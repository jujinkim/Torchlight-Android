package com.mashup.torchlight.adapter

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
            PagePos.EMAIL_INPUT.pos -> SignUpEmailInputFragment.newInstance(movePageListener)
            PagePos.EMAIL_AUTH.pos -> SignUpEmailAuthFragment.newInstance(movePageListener)
            PagePos.EMAIL_USERINFO.pos -> SignUpUserInfoFragment.newInstance(movePageListener)
            PagePos.EMAIL_SUCCESS.pos -> SignUpSuccessFragment.newInstance(movePageListener)

            else -> SignUpEmailInputFragment.newInstance(movePageListener)  // bullshit. just return anything
        }
    }

    companion object {
        enum class PagePos(val pos: Int) {
            EMAIL_INPUT(0), EMAIL_AUTH(1), EMAIL_USERINFO(2), EMAIL_SUCCESS(3)
        }
    }
}