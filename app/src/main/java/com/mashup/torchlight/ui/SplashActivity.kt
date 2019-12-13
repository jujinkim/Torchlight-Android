package com.mashup.torchlight.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mashup.torchlight.ui.signin.SignInActivity
import com.mashup.torchlight.work.initializer.ITorchlightInitializerListener
import com.mashup.torchlight.work.initializer.TorchlightInitializer
import org.jetbrains.anko.startActivity
import timber.log.Timber

class SplashActivity : AppCompatActivity(), ITorchlightInitializerListener {

    private val initializer = TorchlightInitializer(this)
    private var initStartTimeStamp = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializer.startInit()
    }

    override fun onInitializeBegin() {

        Timber.v("Start Torchlight initialize")
        initStartTimeStamp = System.currentTimeMillis()
    }

    override fun onInitializeDone() {
        val initPeriod = System.currentTimeMillis() - initStartTimeStamp
        Timber.v("Finish Torchlight initialize. It took $initPeriod")

        // Todo : If there is already a signed in user account, skip SignInActivity and go to MainActivity directly
        startActivity<SignInActivity>()
        finish()
    }
}
