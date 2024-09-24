package com.meianoitedev.carshop.ui.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meianoitedev.carshop.ui.theme.colorIconTextField
import com.meianoitedev.carshop.ui.theme.colorTextFieldContainer
import com.meianoitedev.carshop.ui.theme.myCustomFont


@Composable
fun MyTextField(
    modifier: Modifier,
    value: String,
    label: String,
    placeholder: String,
    singleLine: Boolean = true,
    charLimit: Int,
    functionTrailingIcon: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    shape: Shape = TextFieldDefaults.shape,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    showEmailError: Boolean
) {
    TextField(
        textStyle = TextStyle(fontFamily = myCustomFont),
        value = value,
        onValueChange = {
            if (it.length <= charLimit) {
                onValueChange(it)
            }
        },
        modifier = modifier,
        label = {
            Text(
                text = label,
                color = colorIconTextField,
                fontFamily = myCustomFont
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                color = colorIconTextField,
                fontFamily = myCustomFont
            )
        },
        trailingIcon = { functionTrailingIcon() },
        visualTransformation = visualTransformation,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        shape = shape,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorTextFieldContainer,
            unfocusedContainerColor = colorTextFieldContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        supportingText = {
            if (showEmailError) {
                Text(
                    text = "Invalid Email",
                    color = Color.Red,
                    fontFamily = myCustomFont
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultTextFieldPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField(
            value = "",
            label = "Example",
            onValueChange = {},
            placeholder = "Enter your name",
            charLimit = 8,
            showEmailError = false,
            shape = TextFieldDefaults.shape,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default,
            visualTransformation = VisualTransformation.None,
            modifier = Modifier.padding(16.dp),
            functionTrailingIcon = {}
        )
    }
}