package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpUserInfoBinding

class SignUpUserInfoFragment(private val movePageListener: SignUpActivity.ISignUpMovePageListener)
    : SignUpBaseFragment<FragmentSignUpUserInfoBinding>(R.layout.fragment_sign_up_user_info, movePageListener) {

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
        fun newInstance(movePageListener: SignUpActivity.ISignUpMovePageListener) =
            SignUpUserInfoFragment(movePageListener)
    }
}
