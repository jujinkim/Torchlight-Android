package com.mashup.torchlight.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentHomeBinding
import com.mashup.torchlight.ui.base.BaseFragment
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onPause() {
        Timber.e("onPause")
        super.onPause()
    }

    override fun onStop() {
        Timber.e("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Timber.e("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Timber.e("onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Timber.e("onDetach")
        super.onDetach()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
