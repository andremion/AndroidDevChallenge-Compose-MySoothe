package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.PrimaryButton
import com.example.androiddevchallenge.ui.component.SecondaryButton

@Composable
fun WelcomeScreen(
    onSignUpClick: () -> Unit,
    onLoginInClick: () -> Unit
) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.bg_welcome),
        contentScale = ContentScale.FillBounds,
        contentDescription = null
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(bottom = 32.dp),
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_name)
        )
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = stringResource(R.string.welcome_screen_signup_button),
            onClick = onSignUpClick
        )
        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.welcome_screen_login_button),
            onClick = onLoginInClick
        )
    }
}
