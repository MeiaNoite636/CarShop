package com.meianoitedev.carshop.ui.components.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.ui.theme.ColorText
import com.meianoitedev.carshop.ui.theme.myCustomFont


//Ready
@Composable
fun MyTextButton(
    onClick: () -> Unit,
    text: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    colorText: Color
) {

    TextButton(
        onClick = { onClick() },
        content = {
            MyText(
                fontWeight = fontWeight,
                fontSize = fontSize,
                colorText = colorText,
                textTitle = text
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MyTextButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyTextButton(
            onClick = {},
            text = "Hello World",
            fontWeight = FontWeight(700),
            fontSize = 18.sp,
            colorText = ColorText
        )
    }
}