package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpEmailAuthBinding

class SignUpEmailAuthFragment(private val movePageListener: SignUpActivity.ISignUpMovePageListener)
    : SignUpBaseFragment<FragmentSignUpEmailAuthBinding>(R.layout.fragment_sign_up_email_auth, movePageListener) {

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
            SignUpEmailAuthFragment(movePageListener)
    }
}

