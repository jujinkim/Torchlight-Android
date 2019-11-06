package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpEmailInputBinding
import kotlinx.android.synthetic.main.fragment_sign_up_email_input.*

class SignUpEmailInputFragment(private val movePageListener: SignUpActivity.ISignUpMovePageListener)
    : SignUpBaseFragment<FragmentSignUpEmailInputBinding>(R.layout.fragment_sign_up_email_input, movePageListener) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnChkDuplicate.setOnClickListener { viewModel.checkDuplicatedEmail() }
        btnSendAuthCode.setOnClickListener { movePageListener.moveNextPage() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(movePageListener: SignUpActivity.ISignUpMovePageListener) =
            SignUpEmailInputFragment(movePageListener)
    }


}
