package com.meianoitedev.carshop.ui.components.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteIcon(
    onClick: () -> Unit
) {
    IconButton(
        onClick = { onClick() },
        content = {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                tint = Color.Gray,
                contentDescription = null
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun FavoriteIconPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FavoriteIcon(
            onClick = {}
        )
    }
}