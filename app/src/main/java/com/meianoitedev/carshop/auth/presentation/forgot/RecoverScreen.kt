package com.meianoitedev.carshop.auth.presentation.forgot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.ui.components.button.MyButton
import com.meianoitedev.carshop.ui.components.textfield.MyTextField
import com.meianoitedev.carshop.ui.theme.ColorSelectedIconBottomNavBar
import com.meianoitedev.carshop.ui.theme.ColorTextButton
import com.meianoitedev.carshop.ui.theme.LoginColorBackgroundButtonDisabled
import com.meianoitedev.carshop.ui.theme.LoginColorBackgroundButtonEnabled
import com.meianoitedev.carshop.auth.util.isValidEmail
import kotlinx.coroutines.launch

@Composable
fun RecoverScreen(
    recoverViewModel: RecoverViewModel = hiltViewModel()
) {

    var showProgressBar by remember { mutableStateOf(false) }

    val recoverState by recoverViewModel.recoverState.collectAsState()

    val scope = rememberCoroutineScope()

    val snackBarHostState = remember { SnackbarHostState() }

    var showEmailError by remember { mutableStateOf(false) }

    RecoverScreenContent(
        recoverState = recoverState,
        enabled = recoverState.email.isNotEmpty(),
        showEmailError = showEmailError,
        onEmailChange = {
            showEmailError = !isValidEmail(it)
            recoverViewModel.updateEmail(it)
        },
        onForgotPassword = {
            scope.launch {
                showProgressBar = true
                recoverViewModel.recoverPassword(recoverState.email)
            }
        },
        progressBarIndicator = showProgressBar
    )

    LaunchedEffect(Unit) {
        recoverViewModel.forgotEvent.collect{
            when(it){
                is ForgotEvent.Error -> {
                    showProgressBar = false
                    snackBarHostState.showSnackbar(message = it.message)
                }
                is ForgotEvent.Success -> {
                    showProgressBar = false
                    snackBarHostState.showSnackbar(message = "Email sent")
                }
            }
        }
    }

    SnackbarHost(hostState = snackBarHostState)

}

@Composable
private fun RecoverScreenContent(
    modifier: Modifier = Modifier,
    recoverState: RecoverState,
    enabled: Boolean,
    showEmailError: Boolean,
    onEmailChange: (String) -> Unit,
    onForgotPassword: () -> Unit,
    progressBarIndicator: Boolean
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Generic
        MyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = recoverState.email,
            label = "Email",
            placeholder = "example@gmail.com",
            charLimit = 50,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = {
                onEmailChange(it)
            },
            functionTrailingIcon = {
                if (recoverState.email.isNotEmpty()) {
                    IconButton(
                        onClick = { onEmailChange("") },
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = null
                            )
                        }
                    )
                }
            },
            showEmailError = showEmailError
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        //Generic Component
        MyButton(
            enabled = enabled,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonColors(
                containerColor = LoginColorBackgroundButtonEnabled,
                contentColor = ColorTextButton,
                disabledContentColor = ColorTextButton,
                disabledContainerColor = LoginColorBackgroundButtonDisabled,
            ),
            textButton = "Recover",
            onClick = {
                onForgotPassword()
            },
            fontWeightText = FontWeight(700),
            fontSizeText = 16.sp,
            colorText = ColorTextButton

        )

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (progressBarIndicator) CircularProgressIndicator(
                color = ColorSelectedIconBottomNavBar,
                strokeWidth = 2.dp,
            )
        }


        //LinearProgressIndicator()
    }
}


@Preview(showBackground = true)
@Composable
private fun RecoverScreenPreview(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RecoverScreenContent(
            modifier = Modifier,
            recoverState = RecoverState(),
            enabled = true,
            showEmailError = false,
            onEmailChange = {},
            onForgotPassword = {},
            progressBarIndicator = true
        )
    }
}