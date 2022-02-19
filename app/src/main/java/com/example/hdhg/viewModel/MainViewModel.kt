package com.example.hdhg.viewModel

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hdhg.models.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.util.*


class MainViewModel: ViewModel() {

    // Состояние текущей темы в приложении
    private val _isDarkThemeState: MutableState<Boolean> = mutableStateOf(value = false)
    val isDarkThemeState: State<Boolean> = _isDarkThemeState
    fun changeThemeState() = run { _isDarkThemeState.value = !_isDarkThemeState.value }

    // Список найденных приложений
    private val _appsList: MutableState<MutableList<App>> = mutableStateOf(value = mutableListOf())
    val appsList: State<MutableList<App>> = _appsList
    fun addApp(app: App) = _appsList.value.add(app)
    fun clearApp() = _appsList.value.clear()


    fun scan(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {

            clearApp()

            val pM = context.packageManager
            val packs = pM.getInstalledPackages(PackageManager.GET_META_DATA)

            packs.forEach {
                val appInfo = it.applicationInfo
                if (appInfo.flags and (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP or ApplicationInfo.FLAG_SYSTEM) <= 0) {

                    addApp(
                        App(
                            label = appInfo.loadLabel(pM).toString(),
                            size = File(appInfo.publicSourceDir).length(),
                            installDate = it.firstInstallTime,
                            targetSdk = appInfo.targetSdkVersion,
                            icon = appInfo.loadIcon(pM).toBitmap()
                        )
                    )

                }
            }
        }
    }

}