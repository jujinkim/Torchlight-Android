package com.mashup.torchlight.work.network

import com.mashup.torchlight.model.SignUpModel
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitSignUpService {

    @POST("/api/v1/issue/code")
    fun issueAuthCode(@Path("emailAddress") emailAddress: String)
    : Call<SignUpModel>

    @POST("/api/v1/verify/code")
    fun verifyAutoCode(@Path("emailAddress") emailAddress: String,
                       @Path("autoCode") autoCode: String)
    : Call<SignUpModel>

}