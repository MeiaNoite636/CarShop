package com.meianoitedev.carshop.ui.components.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.ui.theme.ColorText
import com.meianoitedev.carshop.ui.theme.myCustomFont

//Ready
@Composable
fun MyText(
    fontWeight: FontWeight,
    fontSize: TextUnit,
    colorText: Color,
    textTitle: String,
    modifier: Modifier = Modifier
) {
    Text(
        fontWeight = fontWeight,
        fontFamily = myCustomFont,
        fontSize = fontSize,
        color = colorText,
        text = textTitle,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun MyTextPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText(
            fontSize = 24.sp,
            colorText = ColorText,
            textTitle = "Hello World",
            modifier = Modifier,
            fontWeight = FontWeight.Normal
        )
    }
}

