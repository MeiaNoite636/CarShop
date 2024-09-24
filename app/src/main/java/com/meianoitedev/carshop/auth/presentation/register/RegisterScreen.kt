package com.meianoitedev.carshop.auth.presentation.register

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
fun RegisterScreen(
    registerToHomeGraph: () -> Unit
) {
    val registerViewModel: RegisterViewModel = hiltViewModel()
    val registerState by registerViewModel.registerState.collectAsState()

    val scope = rememberCoroutineScope()

    var showEmailError by remember { mutableStateOf(false) }

    val snackBarHostState = remember { SnackbarHostState() }

    var showProgressBar by remember { mutableStateOf(false) }

    RegisterScreenContent(
        registerState = registerState,
        enabled = registerState.email.isNotEmpty() && registerState.password.isNotEmpty(),
        showEmailError = showEmailError,
        onEmailChange = {
            showEmailError = !isValidEmail(it)
            registerViewModel.updateEmail(it)
        },
        onPasswordChange = {
            registerViewModel.updatePassword(it)
        },
        onRegisterClick = {
            scope.launch {
                showProgressBar = true
                registerViewModel.registerUser(registerState.email, registerState.password)
            }
        },
        progressBarIndicator = showProgressBar
    )

    LaunchedEffect(Unit) {
        registerViewModel.registerEvent.collect {
            when (it) {
                is RegisterEvent.Error -> {
                    showProgressBar = false
                    snackBarHostState.showSnackbar(message = it.message)
                }

                is RegisterEvent.Success -> {
                    showProgressBar = false
                    registerToHomeGraph()
                }
            }
        }
    }

    SnackbarHost(hostState = snackBarHostState)
}


@Composable
private fun RegisterScreenContent(
    modifier: Modifier = Modifier,
    registerState: RegisterState,
    enabled: Boolean,
    showEmailError: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
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
            value = registerState.email,
            label = "Email",
            placeholder = "example@gmail.com",
            charLimit = 50,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = {
                onEmailChange(it)
            },
            functionTrailingIcon = {
                if (registerState.email.isNotEmpty()) {
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

        //Generic
        MyTextField(
            modifier = modifier.fillMaxWidth(),
            value = registerState.password,
            label = "Password",
            placeholder = "",
            charLimit = 8,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = {
                onPasswordChange(it)
            },
            visualTransformation = PasswordVisualTransformation(),
            showEmailError = false,
            functionTrailingIcon = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hide_password),
                        contentDescription = null
                    )
                }
            }
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        //Generic
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
            textButton = "Register",
            onClick = {
                onRegisterClick()
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

        Spacer(modifier = Modifier.padding(top = 16.dp))


        //LinearProgressIndicator()
    }
}


@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RegisterScreenContent(
            modifier = Modifier,
            registerState = RegisterState(),
            enabled = true,
            showEmailError = false,
            onEmailChange = {},
            onPasswordChange = {},
            onRegisterClick = {},
            progressBarIndicator = true
        )
    }
}