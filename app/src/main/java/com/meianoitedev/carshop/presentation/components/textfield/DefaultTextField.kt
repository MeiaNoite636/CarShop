package com.meianoitedev.carshop.presentation.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meianoitedev.carshop.ui.theme.colorIconTextField
import com.meianoitedev.carshop.ui.theme.colorTextFieldContainer


@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    placeholder: String,
    singleLine: Boolean = true,
    charLimit: Int,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    shape: Shape = TextFieldDefaults.shape,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    tint: Color = Color.Gray,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    showEmailError: Boolean
) {
    TextField(

        value = value,
        onValueChange = {
            if (it.length <= charLimit) {
                onValueChange(it)
            }
        },
        modifier = modifier,
        label = { Text(
            text = label,
            color = colorIconTextField
        ) },
        placeholder = { Text(text = placeholder, color = colorIconTextField) },
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(start = 16.dp),
                imageVector = icon,
                contentDescription = null,
                tint = tint
            )
        },
        trailingIcon = {
            if (value.isNotEmpty()){
                IconButton(
                    onClick = { onValueChange("") },
                    content = {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null
                        )
                    }
                )
            }
        },
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
                    text = "Email inválido",
                    color = Color.Red
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
        DefaultTextField(
            value = "",
            label = "Example",
            onValueChange = {},
            placeholder = "Enter your name",
            charLimit = 8,
            icon = Icons.Default.LocationOn,
            showEmailError = false
        )
    }

}