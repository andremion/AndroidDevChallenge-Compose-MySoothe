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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.login.LoginScreen
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

@Suppress("DEPRECATION")
private fun Window.makeTransparentStatusBar() {
    decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    statusBarColor = Color.TRANSPARENT
    WindowInsetsControllerCompat(this, decorView).isAppearanceLightStatusBars = true
}

enum class MainNavigation { Welcome, Login, Home }

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(16.dp)
    ) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = MainNavigation.Welcome.name) {
            composable(MainNavigation.Welcome.name) {
                WelcomeScreen(
                    onSignUpClick = {},
                    onLoginInClick = { navController.navigate(MainNavigation.Login.name) }
                )
            }
            composable(MainNavigation.Login.name) {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate(MainNavigation.Home.name) {
                            popUpTo(navController.graph.startDestination) { inclusive = true }
                        }
                    }
                )
            }
            composable(MainNavigation.Home.name) {
                HomeScreen()
            }
        }
    }
}

@Composable
fun NavHostController.currentRoute(): String? {
    val navBackStackEntry by currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
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
