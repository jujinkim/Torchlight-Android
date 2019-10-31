package com.mashup.torchlight.ui.main

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.ActivityMainBinding
import com.mashup.torchlight.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
