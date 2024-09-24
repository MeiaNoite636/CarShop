package com.meianoitedev.carshop.profile_feature.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.ui.components.button.MyOutlinedButton
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorCerulian
import com.meianoitedev.carshop.ui.theme.ColorText
import com.meianoitedev.carshop.ui.theme.ColorUnselectedIconBottomNavBar

@Composable
fun ProfileScreen(
    name: String,
    email: String,
    onNavigateToRequests: () -> Unit
) {
    ProfileScreenContent(
        name = name,
        email = email,
        onClick = onNavigateToRequests
    )
}

@Composable
fun ProfileScreenContent(
    modifier: Modifier = Modifier,
    name: String,
    email: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 200.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = modifier
                .width(100.dp)
                .height(100.dp),
            shape = RoundedCornerShape(70.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

        }

        Spacer(modifier = modifier.height(16.dp))

        MyText(
            fontWeight = FontWeight(600),
            fontSize = 18.sp,
            colorText = ColorText,
            textTitle = name
        )

        MyText(
            fontWeight = FontWeight(600),
            fontSize = 16.sp,
            colorText = ColorUnselectedIconBottomNavBar,
            textTitle = email
        )

        Spacer(modifier = modifier.height(80.dp))

        MyOutlinedButton(
            modifier = modifier.fillMaxWidth(),
            textTitle = "My requests",
            onClick = onClick,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = ColorText,
                disabledContentColor = ColorText,
                disabledContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp),
            fontWeightText = FontWeight(500),
            fontSizeText = 14.sp,
            colorText = ColorCerulian,
            border = BorderStroke(width = 1.3.dp, ColorCerulian)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileScreenContent(
            name = "William dos Santos",
            email = "John@gmail.com",
            onClick = {}
        )
    }
}

