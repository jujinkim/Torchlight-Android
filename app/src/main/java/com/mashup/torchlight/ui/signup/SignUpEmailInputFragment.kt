package com.mashup.torchlight.ui.signup

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpEmailInputBinding
import com.mashup.torchlight.ui.base.BaseFragment
import com.mashup.torchlight.viewmodel.SignUpViewModel

class SignUpEmailInputFragment
    : BaseFragment<FragmentSignUpEmailInputBinding>(R.layout.fragment_sign_up_email_input) {

    private lateinit var viewModel: SignUpViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpEmailInputFragment()
    }


}
