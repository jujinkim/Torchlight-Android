package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpEmailAuthBinding
import com.mashup.torchlight.ui.base.BaseFragment
import com.mashup.torchlight.viewmodel.SignUpViewModel

class SignUpEmailAuthFragment
    : BaseFragment<FragmentSignUpEmailAuthBinding>(R.layout.fragment_sign_up_email_auth) {

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
        fun newInstance() =
            SignUpEmailAuthFragment()
    }
}

