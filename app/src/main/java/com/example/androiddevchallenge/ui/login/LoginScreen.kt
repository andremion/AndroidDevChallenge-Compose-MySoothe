package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.InputText
import com.example.androiddevchallenge.ui.component.PrimaryButton
import java.util.*

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
            label = stringResource(R.string.login_screen_field_email_label),
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { email = it }
        )

        var password by rememberSaveable { mutableStateOf("") }
        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = stringResource(R.string.login_screen_field_password_label),
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
