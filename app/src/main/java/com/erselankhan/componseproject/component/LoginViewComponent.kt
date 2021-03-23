package com.erselankhan.componseproject.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Text(
                text = "Sign In",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            )
            var emailField by remember {
                mutableStateOf("Email Text")
            }
            var passwordField by remember {
                mutableStateOf("Password Text")
            }

            EmailTextField(emailField, onEmailChange = { emailField = it })
            PasswordTextField(passwordField, onPasswordChange = {passwordField = it})
            LoginButton( onClick =  {
                if (validateFields(emailField, passwordField)) {
                    Log.e("Testing", "Login")
                } else {
                    Log.e("Testing", "Error")
                }
            })
        }
    }
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
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

fun validateFields(emailField: String, passwordField: String): Boolean {
    return (emailField.contains("@") && passwordField.length >= 6)
}

@Composable
fun EmailTextField(emailField: String, onEmailChange: (String) -> Unit) {
    OutlinedTextField(
        value = emailField,
        onValueChange = { onEmailChange(it) },
        label = { Text("Email Address") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
fun PasswordTextField(passwordField: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = passwordField,
        onValueChange = { onPasswordChange(it) },
        label = { Text("Password") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.padding(2.dp),
        visualTransformation = PasswordVisualTransformation()
    )
}