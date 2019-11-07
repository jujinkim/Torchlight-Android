package com.mashup.torchlight.viewmodel

import androidx.databinding.ObservableField
import com.mashup.torchlight.model.SignUpModel
import com.mashup.torchlight.work.SignUpWork

class SignUpViewModel : BaseViewModel() {
    var data: SignUpModel =
        SignUpModel("","","","","",false)

    val sendAuthBtnEnabled = ObservableField(false)

    val signUpWork = SignUpWork()

    fun isPasswordConfirmed() : Boolean {
        return data.passwd == data.passwdConfirm
    }

    fun isAuthCodeSame(input: String): Boolean {
        return input == data.authCode
    }

    fun isBasicInfoFilled(): Boolean {
        return data.emailAddress.isNotEmpty()
                && data.name.isNotEmpty()
                && data.passwd.isNotEmpty()
    }

    fun checkDuplicatedEmail() {
        sendAuthBtnEnabled.set(!signUpWork.isDuplicatedEmail(data.emailAddress))
    }

    fun isPasswordConditionMatched(): Boolean {
        /*
        Password Condition:
        one more alphabet + one more number + one more special character + 10 or over characters
        */

        return true
    }

}
