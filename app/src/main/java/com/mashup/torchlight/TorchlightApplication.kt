package com.mashup.torchlight

import android.app.Application
import com.mashup.torchlight.di.networkModule
import com.mashup.torchlight.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import timber.log.Timber

class TorchlightApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        //디버깅 버전에서만 Timber 로그를 남깁니다.
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupKoin() {
        startKoin {
            //디버깅 버전에서만 코인 로그를 남깁니다.
            logger(
                if (BuildConfig.DEBUG) {
                    AndroidLogger()
                } else {
                    EmptyLogger()
                }
            )

            //context를 koin container에 추가합니다.
            androidContext(this@TorchlightApplication)

            //module을 로딩합니다.
            modules(
                listOf(
                    networkModule, viewModelModule
                )
            )
        }
    }
}