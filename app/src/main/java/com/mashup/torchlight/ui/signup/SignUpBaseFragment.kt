package com.mashup.torchlight.ui.signup

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.mashup.torchlight.BR
import com.mashup.torchlight.ui.base.BaseFragment
import com.mashup.torchlight.viewmodel.SignUpViewModel

open class SignUpBaseFragment<B : ViewDataBinding>(
    private val layoutId: Int,
    protected val movePage: SignUpActivity.ISignUpMovePageListener
) : BaseFragment<B>(layoutId) {
    protected lateinit var viewModel: SignUpViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(SignUpViewModel::class.java)
        binding.setVariable(BR.signup, viewModel)

    }

}