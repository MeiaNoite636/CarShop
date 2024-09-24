package com.meianoitedev.carshop.auth.presentation.login


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.ui.components.button.MyButton
import com.meianoitedev.carshop.ui.components.button.MyOutlinedButton
import com.meianoitedev.carshop.ui.components.text.MyTextButton
import com.meianoitedev.carshop.ui.components.textfield.MyTextField
import com.meianoitedev.carshop.ui.theme.ColorCerulian
import com.meianoitedev.carshop.ui.theme.ColorText
import com.meianoitedev.carshop.ui.theme.ColorTextButton


@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    loginToHomeGraph: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val snackBarHostState = remember { SnackbarHostState() }

    LoginScreenContent(
        loginState = loginViewModel.loginState.collectAsState().value,
        onForgotPasswordClick = { onForgotPasswordClick() },
        onNavigateToRegister = { onNavigateToRegister() },
        loginEvent = loginViewModel::handleEvent
    )

    LaunchedEffect(Unit) {
        loginViewModel.loginState.collect { loginState ->
            if (loginState.isSuccessful) {
                loginToHomeGraph()
            } else {
                loginState.error?.let {
                    snackBarHostState.showSnackbar(it)
                }
            }
        }
    }

    SnackbarHost(hostState = snackBarHostState)

}

@Composable
private fun LoginScreenContent(
    modifier: Modifier = Modifier,
    loginState: LoginState,
    onForgotPasswordClick: () -> Unit,
    onNavigateToRegister: () -> Unit,
    loginEvent: (LoginEvent) -> Unit
) {
    var hidePassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Generic
        MyTextField(
            modifier = modifier.fillMaxWidth(),
            value = loginState.email,//
            label = "Email",
            placeholder = "example@gmail.com",
            charLimit = 50,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = { loginEvent(LoginEvent.EmailChanged(it)) },
            functionTrailingIcon = {
                if (loginState.email.isNotEmpty()) {
                    IconButton(
                        onClick = { loginEvent(LoginEvent.EmptyEmail) },
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = null
                            )
                        }
                    )
                }
            },
            showEmailError = false
        )

        //Generic
        MyTextField(
            modifier = modifier.fillMaxWidth(),
            value = loginState.password,//
            label = "Password",
            placeholder = "",
            charLimit = 8,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = {
                loginEvent(LoginEvent.PasswordChanged(it))
            },
            visualTransformation = if (hidePassword) VisualTransformation.None else PasswordVisualTransformation(),
            showEmailError = false,
            functionTrailingIcon = {
                IconButton(onClick = { hidePassword = !hidePassword }) {
                    Icon(
                        painter = if (hidePassword) painterResource(id = R.drawable.ic_show_password) else painterResource(
                            id = R.drawable.ic_hide_password
                        ),
                        contentDescription = null
                    )
                }
            }
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        //Generic
        MyButton(
            enabled = loginState.isNotEmpty(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonColors(
                containerColor = ColorCerulian,
                contentColor = ColorTextButton,
                disabledContentColor = ColorTextButton,
                disabledContainerColor = ColorCerulian,
            ),
            textButton = stringResource(id = R.string.text_login_button),
            onClick = { loginEvent(LoginEvent.Login) },
            fontWeightText = FontWeight(700),
            fontSizeText = 16.sp,
            colorText = ColorTextButton,
            isLoading = loginState.isLoading
        )

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            //Generic
            MyTextButton(
                onClick = onForgotPasswordClick,
                text = "Forgot password?",
                fontWeight = FontWeight(600),
                fontSize = 14.sp,
                colorText = ColorText
            )
        }

        Spacer(modifier = Modifier.padding(top = 16.dp))

        MyOutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            textTitle = "Create new account",
            onClick = onNavigateToRegister,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = ColorText,
                disabledContentColor = ColorText,
                disabledContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(24.dp),
            fontWeightText = FontWeight(700),
            fontSizeText = 14.sp,
            colorText = ColorText,
            border = BorderStroke(
                width = 1.dp,
                color = ColorText
            )
        )


        //LinearProgressIndicator()
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {

    LoginScreenContent(
        modifier = Modifier,
        loginState = LoginState(),
        onForgotPasswordClick = {},
        onNavigateToRegister = {},
        loginEvent = {}
    )
}



