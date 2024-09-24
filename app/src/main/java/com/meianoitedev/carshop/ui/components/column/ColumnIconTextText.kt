package com.meianoitedev.carshop.ui.components.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorIcons
import com.meianoitedev.carshop.ui.theme.ColorPrussianBlue

@Composable
fun <T>ColumnIconTextText(
    modifier: Modifier,
    icon: Painter,
    data: T
) {

    Column {
        Icon(
            modifier = modifier.size(24.dp),
            painter = icon,
            tint = ColorPrussianBlue,
            contentDescription = null
        )

        MyText(
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            colorText = ColorIcons,
            textTitle = "Announcement Date"
        )

        MyText(
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            colorText = ColorIcons,
            textTitle = "$data"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ColumnIconTextTextPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColumnIconTextText(
            icon = painterResource(id = R.drawable.ic_newcalendar),
            data = "2012",
            modifier = Modifier
        )
    }
}