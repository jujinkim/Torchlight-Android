package com.mashup.torchlight.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mashup.torchlight.model.ProfileModel

class ProfileViewModel : ViewModel() {
    val data = MutableLiveData<ProfileModel>()
    val isUserBasicInfoVisible = MutableLiveData<Boolean>()

    init {
        data.value = ProfileModel()
    }
}