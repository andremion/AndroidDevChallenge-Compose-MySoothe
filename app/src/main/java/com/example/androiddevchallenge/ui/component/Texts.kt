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
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    placeholder: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit
) {
    val textStyle = MaterialTheme.typography.body1.copy(baselineShift = BaselineShift(-0.2f))
    TextField(
        modifier = modifier.height(56.dp),
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = it,
                    contentDescription = null
                )
            }
        },
        placeholder = {
            Text(
                text = placeholder,
                style = textStyle
            )
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
    )
}

@Preview
@Composable
private fun PlaceholderPreview() {
    MyTheme {
        InputText(placeholder = "placeholder", value = "", onValueChange = { })
    }
}

@Preview
@Composable
private fun ValuePreview() {
    MyTheme {
        InputText(placeholder = "", value = "Value", onValueChange = { })
    }
}
