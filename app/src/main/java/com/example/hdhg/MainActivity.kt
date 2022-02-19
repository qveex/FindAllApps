package com.example.hdhg

import android.content.pm.PackageManager
import android.os.Bundle
import android.text.format.Formatter.formatFileSize
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.core.graphics.drawable.toBitmap
import com.example.hdhg.screens.MainScreen
import com.example.hdhg.ui.theme.HdhgTheme
import com.example.hdhg.viewModel.MainViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val packs = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)

        /*packs.forEach {

            val appInfo = it.applicationInfo
            val formatter = SimpleDateFormat("dd.MM.yyyy")
            val installDate = formatter.format(Date(it.firstInstallTime))
            val size = formatFileSize(applicationContext, File(appInfo.publicSourceDir).length())
            val icon = appInfo.loadIcon(packageManager).toBitmap()

            Log.i("Apps", "name = " + appInfo.loadLabel(packageManager))
            Log.i("Apps", "date = $installDate")
            Log.i("Apps", "size = $size")
            Log.i("Apps", "sdk = " + appInfo.targetSdkVersion)

        }*/

        setContent {
            HdhgTheme(darkTheme = viewModel.isDarkThemeState.value) {
                Surface {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}
