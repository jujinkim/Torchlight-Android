package com.mashup.torchlight.ui.signup

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mashup.torchlight.R
import com.mashup.torchlight.adapter.SignUpFragmentAdapter
import com.mashup.torchlight.databinding.ActivitySignUpBinding
import com.mashup.torchlight.ui.base.BaseActivity
import com.mashup.torchlight.viewmodel.SignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private lateinit var viewModel: SignUpViewModel
    private val movePageListener = object : ISignUpMovePageListener {
        override fun moveNextPage() {
            moveToNextStep()
        }

        override fun movePrevPage() {
            moveToPrevStep()
        }
    }
    private lateinit var signUpAdapter: SignUpFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        signUpAdapter = SignUpFragmentAdapter(supportFragmentManager, lifecycle, movePageListener)
        vpSignUp.adapter = signUpAdapter
        vpSignUp.isUserInputEnabled = false
        vpSignUp.offscreenPageLimit = signUpAdapter.itemCount
    }


    fun moveToNextStep() {
        vpSignUp.setCurrentItem(vpSignUp.currentItem+1, true)
    }

    fun moveToPrevStep() {

    }

    interface ISignUpMovePageListener {
        fun moveNextPage()
        fun movePrevPage()
    }
}
