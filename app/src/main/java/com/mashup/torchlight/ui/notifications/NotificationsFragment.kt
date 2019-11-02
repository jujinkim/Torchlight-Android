package com.mashup.torchlight.ui.notifications

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentNotificationsBinding
import com.mashup.torchlight.ui.base.BaseFragment

class NotificationsFragment : BaseFragment<FragmentNotificationsBinding>(R.layout.fragment_home) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = NotificationsFragment()
    }

}
