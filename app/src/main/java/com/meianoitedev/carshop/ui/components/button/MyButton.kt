package com.meianoitedev.carshop.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
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
import com.meianoitedev.carshop.ui.theme.ColorBackground
import com.meianoitedev.carshop.ui.theme.ColorText
import com.meianoitedev.carshop.ui.theme.LoginColorBackgroundButtonDisabled
import com.meianoitedev.carshop.ui.theme.LoginColorBackgroundButtonEnabled

//Ready
@Composable
fun MyButton(
    modifier: Modifier,
    textButton: String,
    onClick: () -> Unit,
    colors: ButtonColors,
    enabled: Boolean,
    shape: Shape,
    fontWeightText: FontWeight,
    fontSizeText: TextUnit,
    colorText: Color,
    isLoading: Boolean = false
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = colors,
        enabled = enabled,
        shape = shape,
        content = {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = modifier
                        .wrapContentSize(Alignment.Center)
                        .size(16.dp),
                    color = ColorBackground,//
                    strokeWidth = 2.dp,
                )
            } else {
                MyText(
                    fontWeight = fontWeightText,//
                    fontSize = fontSizeText,//
                    colorText = colorText,//
                    textTitle = textButton//
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MyButtonPrev() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyButton(
            modifier = Modifier,
            textButton = "Login",
            onClick = { },
            colors = ButtonColors(
                containerColor = LoginColorBackgroundButtonEnabled,
                contentColor = ColorText,
                disabledContentColor = ColorText,
                disabledContainerColor = LoginColorBackgroundButtonDisabled,
            ),
            enabled = true,
            shape = RoundedCornerShape(16.dp),
            fontWeightText = FontWeight(500),
            fontSizeText = 14.sp,
            colorText = ColorText,
            isLoading = true
        )
    }
}