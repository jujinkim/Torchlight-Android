package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpSuccessBinding

class SignUpSuccessFragment()
    : SignUpBaseFragment<FragmentSignUpSuccessBinding>(R.layout.fragment_sign_up_success) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(
            movePageListener: SignUpActivity.ISignUpMovePageListener
        ): SignUpSuccessFragment {
            val fragment = SignUpSuccessFragment()
            fragment.movePage = movePageListener
            return fragment
        }
    }
}
