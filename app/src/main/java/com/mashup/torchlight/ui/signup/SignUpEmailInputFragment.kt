package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpEmailInputBinding
import com.mashup.torchlight.di.networkModule
import com.mashup.torchlight.model.SignUpModel
import com.mashup.torchlight.work.network.RetrofitSignUpService
import kotlinx.android.synthetic.main.fragment_sign_up_email_input.*
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import org.koin.dsl.module
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SignUpEmailInputFragment()
    : SignUpBaseFragment<FragmentSignUpEmailInputBinding>(R.layout.fragment_sign_up_email_input) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnChkDuplicate.setOnClickListener {
            if (viewModel.isValidEmail()) {
                viewModel.chkDuplicatedAndUpdateAuthBtn()
            } else {
                toast(getString(R.string.signup_email_is_invalid))
            }
        }
        btnSendAuthCode.setOnClickListener {
            sendAutoCodeAndMoveNextPage()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun sendAutoCodeAndMoveNextPage() {
        viewModel.setAuthCodeSendBusy(true)
        viewModel.data.value?.let {
            val retrofit: Retrofit by inject()
            val service = retrofit.create(RetrofitSignUpService::class.java)
            val authCodeReq = service.issueAuthCode(it.emailAddress)

            authCodeReq.enqueue(object: Callback<SignUpModel> {
                override fun onResponse(call: Call<SignUpModel>, response: Response<SignUpModel>) {
                    response.body()?.let {res ->
                        it.authCode = res.authCode
                        movePage.moveNextPage()
                    } ?: toast(R.string.signup_fail_to_send_auth_code)
                    viewModel.setAuthCodeSendBusy(false)
                }

                override fun onFailure(call: Call<SignUpModel>, t: Throwable) {
                    toast(R.string.signup_fail_to_send_auth_code)
                    viewModel.setAuthCodeSendBusy(false)
                }

            })
        }


    }

    companion object {
        @JvmStatic
        fun newInstance(
            movePageListener: SignUpActivity.ISignUpMovePageListener
        ): SignUpEmailInputFragment {
            val fragment = SignUpEmailInputFragment()
            fragment.movePage = movePageListener
            return fragment
        }
    }
}
