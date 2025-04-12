package com.habits.twenty1.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.habits.twenty1.presentation.ui.components.Home
import com.habits.twenty1.presentation.ui.components.HomeScreen
import com.habits.twenty1.presentation.ui.theme.Twenty1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Home()
//            Twenty1Theme {
//                HomeScreen()
//            }
        }
    }
}
