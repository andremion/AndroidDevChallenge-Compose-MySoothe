/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.welcome.WelcomeScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.makeTransparentStatusBar()
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

private fun Window.makeTransparentStatusBar() {
    decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    statusBarColor = Color.TRANSPARENT
    WindowInsetsControllerCompat(this, decorView).isAppearanceLightStatusBars = true
}

@Composable
fun MyApp() {
    val isLightTheme = MaterialTheme.colors.isLight
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(16.dp)
    ) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "welcome") {
            composable("welcome") {
                WelcomeScreen(
                    onSignUpClick = {},
                    onLoginInClick = { navController.navigate("login") }
                )
            }
            composable("login") {
                Text("Login")
            }
            composable("home") {
                Text("Home")
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
