package com.mashup.torchlight.model

data class SignUpModel(
    var emailAddress: String,
    var authCode: String,
    var name: String,
    var passwd: String,
    var passwdConfirm: String,
    var isAgreedDisclaimer: Boolean
)