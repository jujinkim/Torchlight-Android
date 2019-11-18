package com.mashup.torchlight.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProfileConfirmBinding

class CreateProfileConfirmFragment(private val movePageListener: CreateProfileActivity.IMovePageListener)
    : ProfileBaseFragment<FragmentCreateProfileConfirmBinding>(R.layout.fragment_create_profile_confirm, movePageListener) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance(movePageListener: CreateProfileActivity.IMovePageListener) =
            CreateProfileConfirmFragment(movePageListener)
    }
}
