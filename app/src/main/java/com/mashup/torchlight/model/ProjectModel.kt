package com.mashup.torchlight.model

data class ProjectModel(
    val platformType: PlatformType = PlatformType.ANDROID,
    val name: String,
    val description: String,
    val tag: List<String>,
    val recruitmentCnt: Int
)

enum class PlatformType {
    ANDROID, IOS, BACKEND, WEB
}