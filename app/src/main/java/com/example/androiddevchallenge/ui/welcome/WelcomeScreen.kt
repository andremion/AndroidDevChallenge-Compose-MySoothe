package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.PrimaryButton
import com.example.androiddevchallenge.ui.component.SecondaryButton
import java.util.*

@Composable
fun WelcomeScreen(isLightTheme: Boolean) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(
            if (isLightTheme) {
                R.drawable.bg_light_welcome
            } else {
                R.drawable.bg_dark_welcome
            }
        ),
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
        AppName(
            modifier = Modifier.padding(bottom = 32.dp)
        )
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = stringResource(R.string.welcome_screen_signup_button)
        ) {

        }
        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.welcome_screen_login_button)
        ) {

        }
    }
}

@Composable
private fun AppName(modifier: Modifier = Modifier) {
    val text = stringResource(R.string.app_name).toUpperCase(Locale.getDefault())
    val textStyle = MaterialTheme.typography.h1
    val annotatedString = AnnotatedString.Builder(text).run {
        addStyle(textStyle.toSpanStyle().copy(fontWeight = FontWeight.Bold), 2, text.length)
        toAnnotatedString()
    }
    Text(
        modifier = modifier,
        text = annotatedString,
        color = MaterialTheme.colors.onBackground,
        style = textStyle
    )
}
