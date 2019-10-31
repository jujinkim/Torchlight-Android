package com.mashup.torchlight.ui.project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.mashup.torchlight.R
import com.mashup.torchlight.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.activity_create_project.*


class CreateProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)

        //TODO:: categoty 부분 + 버튼3개 커스텀뷰 테스트코드입니당 쓰실경우 이거 쓰면 되고 나중에 지울게요!
        rvCategory.layoutManager = FlexboxLayoutManager(this)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.FLEX_START
        rvCategory.layoutManager = layoutManager

        val categoryList = mutableListOf(
            "ononeonee",
            "two",
            "oneoneone",
            "two",
            "one",
            "onetwo",
            "one",
            "onetwo",
            "one",
            "two"
        )

        val adapter = CategoryAdapter(categoryList)
        rvCategory.adapter = adapter
        adapter.notifyDataSetChanged()

        btnSelectThree.setText("단계","2단계","3단계")
        btnSelectThree.setOnButtonClick(object : CustomThreeBtn.OnButtonClick {
            override fun onSelect(index: Int) {
                btnSelectThree.setCheckId(index)
                Log.e("123123", "" + btnSelectThree.getCheckId())
            }
        })
    }
}
