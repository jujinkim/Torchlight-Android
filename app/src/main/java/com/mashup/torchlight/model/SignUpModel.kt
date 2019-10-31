package com.mashup.torchlight.model

data class SignUpModel(
    var emailAddress: String,
    var authCode: String,
    var name: String,
    var encryptedPassword: String,
    var encryptedPassword2: String,
    var isAgreedDisclaimer: Boolean
)