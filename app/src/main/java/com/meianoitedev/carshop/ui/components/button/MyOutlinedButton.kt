package com.meianoitedev.carshop.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorText

@Composable
fun MyOutlinedButton(
    textTitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    colors: ButtonColors,
    shape: Shape,
    fontWeightText: FontWeight,
    fontSizeText: TextUnit,
    colorText: Color,
    border: BorderStroke
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        shape = shape,
        border = border,
        content = {
            MyText(
                textTitle = textTitle,
                fontWeight = fontWeightText,
                fontSize = fontSizeText,
                colorText = colorText
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MyOutlinedButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyOutlinedButton(
            modifier = Modifier,
            onClick = { },
            textTitle = "Create new account",
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = ColorText,
                disabledContentColor = ColorText,
                disabledContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp),
            fontWeightText = FontWeight(500),
            fontSizeText = 14.sp,
            colorText = ColorText,
            border = BorderStroke(
                width = 1.dp,
                color = ColorText
            )
        )
    }
}