package com.meianoitedev.carshop.ui.components.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun RowItems(
    modifier: Modifier = Modifier,
    textOne: String,
    textTwo: String,
    color: Color,
    fontWeight: FontWeight?,
    fontSize: TextUnit
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Text(
            text = textOne,
            fontSize = fontSize,
            color = color,
            fontWeight = fontWeight
        )

        Text(
            text = textTwo,
            fontSize = fontSize,
            color = color,
            fontWeight = fontWeight
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RowItemsPreview() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RowItems(
            textOne = "Ano",
            textTwo = "2023",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}