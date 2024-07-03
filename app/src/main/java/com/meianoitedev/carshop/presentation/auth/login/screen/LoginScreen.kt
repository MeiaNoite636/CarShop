package com.meianoitedev.carshop.presentation.auth.login.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meianoitedev.carshop.presentation.auth.register.event.RegisterEvent
import com.meianoitedev.carshop.presentation.auth.register.state.RegisterState
import com.meianoitedev.carshop.presentation.auth.register.viewmodel.RegisterViewModel
import com.meianoitedev.carshop.presentation.components.textfield.DefaultTextField
import com.meianoitedev.carshop.ui.theme.colorButtonDisabled
import com.meianoitedev.carshop.ui.theme.colorButtonEnabled
import com.meianoitedev.carshop.ui.theme.colorIconTextField
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginSuccess: () -> Unit
) {

    //Uso do register view model so para teste
    val registerViewModel: RegisterViewModel = hiltViewModel()
    val registerState by registerViewModel.registerState.collectAsState()
    val scope = rememberCoroutineScope()

    val snackBarHostState = remember { SnackbarHostState() }

    var showEmailError by remember { mutableStateOf(false) }

    LoginScreenContent(
        enabled = registerState.email.isNotEmpty() && registerState.password.isNotEmpty(),
        registerState = registerState,
        onLoginClick = {
            scope.launch {
                registerViewModel.register(registerState.email, registerState.password)
                snackBarHostState.showSnackbar(message = "Sucesso")
                onLoginSuccess()
                Log.i("EMAIL", registerState.email)
            }
        },
        onForgotPasswordClick = { onForgotPasswordClick() },
        onNavigateToRegister = { onNavigateToRegister() },
        showEmailError = showEmailError,
        onEmailChange = {
            showEmailError = !isValidEmail(it)
            registerViewModel.updateEmail(it)
        },
        onPasswordChange = {
            registerViewModel.updatePassword(it)
        }
    )

    LaunchedEffect(Unit) {
        registerViewModel.registerEvents.collect { event ->
            when (event) {
                is RegisterEvent.Error -> {

                }

                RegisterEvent.Success -> {

                }
            }
        }
    }
    SnackbarHost(hostState = snackBarHostState)
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    registerState: RegisterState,
    onForgotPasswordClick: () -> Unit,
    enabled: Boolean,
    onNavigateToRegister: () -> Unit,
    showEmailError: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Faça Login na sua conta",
                fontWeight = FontWeight(700),
                fontSize = 24.sp
            )
        }


        Spacer(modifier = Modifier.padding(top = 16.dp))

        DefaultTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            value = registerState.email,
            label = "Email",
            placeholder = "example@gmail.com",
            charLimit = 50,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = {
                onEmailChange(it)
            },
            icon = Icons.Outlined.Email,
            tint = colorIconTextField,
            showEmailError = showEmailError
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        DefaultTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            value = registerState.password,
            label = "Senha",
            placeholder = "",
            charLimit = 8,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            onValueChange = {
                onPasswordChange(it)
            },
            icon = Icons.Outlined.Lock,
            visualTransformation = PasswordVisualTransformation(),
            tint = colorIconTextField,
            showEmailError = false
        )

        Row(
            modifier = modifier
                .align(Alignment.End)
                .padding(end = 16.dp, top = 8.dp)
        ) {
            Text(
                modifier = Modifier.clickable {
                    onForgotPasswordClick()
                },
                color = Color.Gray,
                text = "Esqueceu a senha?"
            )
        }



        Button(
            enabled = enabled,
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonColors(
                containerColor = colorButtonEnabled,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = colorButtonDisabled
            ),
            onClick = {
                onLoginClick()
            }) {
            Text(
                text = "Login",
                fontWeight = FontWeight(700),
                fontSize = 18.sp
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = "Não tem uma conta?",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier.clickable {
                    onNavigateToRegister()
                },
                text = "Inscrever-se",
                color = colorButtonEnabled,
                fontWeight = FontWeight(700)
            )
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {

}



