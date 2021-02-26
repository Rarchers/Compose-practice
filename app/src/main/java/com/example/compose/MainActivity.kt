package com.example.compose


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import com.example.compose.ui.login.loginPage
import com.example.compose.ui.theme.ComposeTheme



class MainActivity : AppCompatActivity() {


    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windows = this.window
        windows.statusBarColor = 0xFFFFFFFF.toInt()

        setContent {
            ComposeTheme{
                loginPage(this)
            }
        }
    }
}



