package com.mashup.torchlight.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mashup.torchlight.ui.mypage.*

class CreateProfileFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val movePageListener: CreateProfileActivity.IMovePageListener
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PagePos.MANDATORY.pos -> EditProfileMandatoryInfoFragment.newInstance(movePageListener)
            PagePos.OPTIONAL.pos -> EditProfileOptionalInfoFragment.newInstance(movePageListener)
            PagePos.CONFIRM.pos -> CreateProfileConfirmFragment.newInstance(movePageListener)
            PagePos.SUCCESS.pos -> CreateProfileSuccessFragment.newInstance(movePageListener)

            else -> CreateProfileConfirmFragment.newInstance(movePageListener)  // bullshit. just return anything
        }    }

    companion object {
        enum class PagePos(val pos: Int) {
            MANDATORY(0), OPTIONAL(1), CONFIRM(2), SUCCESS(3)
        }
    }
}
