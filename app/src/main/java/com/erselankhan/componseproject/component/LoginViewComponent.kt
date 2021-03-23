package com.erselankhan.componseproject.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginView() {
    Box(
        Modifier
            .wrapContentHeight()
            .wrapContentHeight()
            .background(Color.Red)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Sign In",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            )
            EmailTextField()
            PasswordTextField()
            LoginButton()
        }
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = { validateFields() },
        modifier = Modifier
            .padding(2.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text(
            text = "Login",
            color = Color.White
        )
    }
}

fun validateFields() {

}

@Composable
fun EmailTextField() {
    var emailField by remember {
        mutableStateOf("Email Text")
    }

    OutlinedTextField(
        value = emailField,
        onValueChange = { emailField = it },
        label = { Text("Email Address") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
fun PasswordTextField() {
    var passwordField by remember {
        mutableStateOf("Password Text")
    }

    OutlinedTextField(
        value = passwordField,
        onValueChange = { passwordField = it },
        label = { Text("Password") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.padding(2.dp),
        visualTransformation = PasswordVisualTransformation()
    )
}