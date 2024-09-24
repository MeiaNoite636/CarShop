package com.meianoitedev.carshop.ui.components.card.car_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorUnselectedIconBottomNavBar

@Composable
fun FirstRowCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    colorTextTitle: Color,
    fontSize: TextUnit,
    iconEnd: Painter
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        MyText(
            fontWeight = FontWeight(600),
            fontSize = fontSize,
            colorText = colorTextTitle,
            textTitle = title
        )

        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = onClick,
            content = {
                Icon(
                    painter = iconEnd,
                    tint = ColorUnselectedIconBottomNavBar,
                    contentDescription = null
                )
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun FirstRowCardPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FirstRowCard(
            onClick = {},
            title = "Title",
            colorTextTitle = Color.Black,
            fontSize = 18.sp,
            iconEnd = painterResource(id = R.drawable.ic_favorite_heart)
        )
    }
}