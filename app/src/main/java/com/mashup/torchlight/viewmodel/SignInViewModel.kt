package com.mashup.torchlight.viewmodel

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.mashup.torchlight.model.SignInModel

class SignInViewModel : BaseViewModel() {
    val data = MutableLiveData<SignInModel>()

    fun isBasicInfoFilled(): Boolean {
        return data.value?.let {
            return it.emailAddress.isNotEmpty()
                    && it.passwd.isNotEmpty()
        } ?: false
    }

    fun isValidEmail() : Boolean {
        return data.value?.let {
            val matcher = Patterns.EMAIL_ADDRESS.matcher(it.emailAddress)
            return@let matcher.find()
        } ?: false
    }
}