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
package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.InputText
import com.example.androiddevchallenge.ui.component.PrimaryButton
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.bg_login),
        contentScale = ContentScale.FillBounds,
        contentDescription = null
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
            text = stringResource(R.string.login_screen_title).toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.h1
        )

        var email by rememberSaveable { mutableStateOf("") }
        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            placeholder = stringResource(R.string.login_screen_field_email_label),
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { email = it }
        )

        var password by rememberSaveable { mutableStateOf("") }
        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            placeholder = stringResource(R.string.login_screen_field_password_label),
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password = it },
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.login_screen_login_button),
            onClick = onLoginClick
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(R.string.login_screen_signup_text)
            )
            Text(
                modifier = Modifier
                    .clickable { },
                text = stringResource(R.string.login_screen_signup_button),
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        LoginScreen(onLoginClick = { })
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        LoginScreen(onLoginClick = { })
    }
}
