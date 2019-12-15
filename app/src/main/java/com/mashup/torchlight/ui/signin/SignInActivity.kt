package com.mashup.torchlight.ui.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setClickListeners()
    }

    private fun setClickListeners() {
        btnSignIn.setOnClickListener {
            // sign in
        }

        tvSignUp.setOnClickListener {
            startActivity<SignUpActivity>()
        }

        tvFindPw.setOnClickListener {
            toast("Find password...")
        }
    }
}
