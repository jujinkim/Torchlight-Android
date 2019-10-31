package com.mashup.torchlight.ui.main.mypage

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentMyPageBinding
import com.mashup.torchlight.ui.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = MyPageFragment()
    }

}
