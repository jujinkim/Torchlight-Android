package com.mashup.torchlight.ui.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.ui.main.MainActivity
import com.mashup.torchlight.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_start.*
import org.jetbrains.anko.startActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btnDemo.setOnClickListener {
            startActivity<MainActivity>();
            finish()
        }
        btnSignUp.setOnClickListener {
            startActivity<SignUpActivity>()
        }
        tvSignIn.setOnClickListener {
            startActivity<SignInActivity>()
        }
    }
}
