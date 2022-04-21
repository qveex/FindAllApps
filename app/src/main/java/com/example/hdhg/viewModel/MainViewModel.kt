package com.example.hdhg.viewModel

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hdhg.models.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File


class MainViewModel: ViewModel() {

    // Состояние текущей темы в приложении
    private val _isDarkThemeState: MutableState<Boolean> = mutableStateOf(value = false)
    val isDarkThemeState get() = _isDarkThemeState
    fun changeThemeState() = run { _isDarkThemeState.value = !_isDarkThemeState.value }

    // Список найденных приложений
    private val _appsList = mutableStateListOf<App>()
    val appsList: List<App> get() = _appsList
    fun getApp(id: Int) = _appsList.find { it.id == id }?: App(-1, "Error", 0, 0, 0, _appsList.first().icon)


     fun scan(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {

            if (appsList.isNotEmpty()) return@launch

            val pM = context.packageManager
            val packs = pM.getInstalledPackages(PackageManager.GET_META_DATA)
            var index = 0
            packs.forEach {
                val appInfo = it.applicationInfo
                if (appInfo.flags and (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP or ApplicationInfo.FLAG_SYSTEM) <= 0) {
                    val size = File(appInfo.publicSourceDir).length() + File(appInfo.dataDir).length() + File(appInfo.sourceDir).length()
                    _appsList.add(
                        App(
                            id = index,
                            label = appInfo.loadLabel(pM).toString(),
                            size = size,
                            installDate = it.firstInstallTime,
                            targetSdk = appInfo.targetSdkVersion,
                            icon = appInfo.loadIcon(pM).toBitmap()
                        )
                    ).also { index++ }
                }
            }
        }
    }
}