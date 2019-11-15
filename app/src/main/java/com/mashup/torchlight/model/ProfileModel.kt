package com.mashup.torchlight.model

data class ProfileModel(
    var userName: String,
    var jobId: Int,
    var OccupationId: Int,
    val skillIds: IntArray,
    var interestIds: IntArray,
    var passion: Int,
    var categoryIds: IntArray,
    val urls: ArrayList<String>
)