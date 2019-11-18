package com.mashup.torchlight.model

data class ProfileModel(
    var userName: String = "",
    var jobId: Int = 0,
    var OccupationId: Int = 0,
    val skillIds: IntArray = IntArray(3),
    var interestIds: IntArray = IntArray(3),
    var passion: Int = 0,
    var categoryIds: IntArray = IntArray(3),
    val urls: ArrayList<String> = ArrayList(),
    var detail: String = ""
)