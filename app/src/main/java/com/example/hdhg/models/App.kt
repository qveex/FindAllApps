package com.example.hdhg.models

import android.graphics.Bitmap
import android.text.format.Formatter
import java.text.SimpleDateFormat
import java.util.*


data class App(
    val id: Int,
    val label: String,
    val size: Long,
    val installDate: Long,
    val targetSdk: Int,
    val icon: Bitmap
) {
    fun getSizeInMB() = size / 1048576

    fun getInstallDate() = SimpleDateFormat("dd.MM.yyyy").format(Date(installDate))
}
