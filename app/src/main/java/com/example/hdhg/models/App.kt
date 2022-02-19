package com.example.hdhg.models

import android.graphics.Bitmap
import android.text.format.Formatter
import java.text.SimpleDateFormat
import java.util.*


data class App(
    val label: String,
    val size: Long,
    val installDate: Long,
    val targetSdk: Int,
    val icon: Bitmap
) {
    fun getSizeInMB() = Formatter.formatFileSize(null, size)

    fun getInstallDate() = SimpleDateFormat("dd.MM.yyyy").format(Date(installDate))
}
