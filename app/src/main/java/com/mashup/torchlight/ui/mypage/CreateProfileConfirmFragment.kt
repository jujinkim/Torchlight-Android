package com.mashup.torchlight.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R

class CreateProfileConfirmFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_profile_confirm, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            CreateProfileConfirmFragment().apply {

            }
    }
}
