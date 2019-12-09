package com.mashup.torchlight.ui.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.mashup.torchlight.BR
import com.mashup.torchlight.R
import com.mashup.torchlight.adapter.BaseRecyclerViewAdapter
import com.mashup.torchlight.databinding.FragmentHomeBinding
import com.mashup.torchlight.databinding.ItemProjectBinding
import com.mashup.torchlight.model.ProjectModel
import com.mashup.torchlight.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButton()
        initSpinner()
        setUpRecycleView()
    }

    private fun initButton() {

        btnFragmentHomeSearch.setOnClickListener {
            toast("검색 화면 이동")
        }
    }

    private fun initSpinner() {

        val items = arrayOf("아이템0", "아이템1", "아이템2", "아이템3", "아이템4")

        val myAdapter =
            ArrayAdapter(requireContext(), R.layout.item_spinner_filter, items)

        spFragmentHomeFilter1.adapter = myAdapter
        spFragmentHomeFilter1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {

                    }
                    else -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spFragmentHomeFilter2.adapter = myAdapter
        spFragmentHomeFilter2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {

                    }
                    else -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setUpRecycleView() {
        with(binding.rvFragmentHomeProject) {
            adapter = object : BaseRecyclerViewAdapter<ProjectModel, ItemProjectBinding>(
                layoutRes = R.layout.item_project,
                bindingVariableId = BR.itemProject
            ) {}

            val items = mutableListOf(
                ProjectModel(
                    name = "name1",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name2",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name3",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name4",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name5",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                )
            )

            (adapter as BaseRecyclerViewAdapter<Any, *>).run {
                replaceAll(items)
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
