package com.example.wellspring.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var confirmPasswordValue by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 42.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Headline("Create an Account")
            Spacer(Modifier.height(32.dp))
            SignUpEmailInput(email = emailValue, onEmailChange = { emailValue = it })
            SignUpPasswordInput(label = "Password", password = passwordValue, onPasswordChange = { passwordValue = it })
            SignUpPasswordInput(label = "Confirm Password", password = confirmPasswordValue, onPasswordChange = { confirmPasswordValue = it })
            SignUpSubmitButton(navController, emailValue, passwordValue)
            DividerWithText("OR")
            SignUpWithGoogleButton()
        }
    }
}

@Composable
fun Headline(text: String) {
    Text(text, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))
}

@Composable
fun SignUpEmailInput(email: String, onEmailChange: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email Address") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SignUpPasswordInput(label: String, password: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(label) },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SignUpSubmitButton(navController: NavController, email: String, password: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        onClick = {
            // Implement user registration with Firebase
            val auth = Firebase.auth
            auth.createUserWithEmailAndPassword(
                email.trim(),
                password.trim()
            )
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("AUTH","Success")
                        navController.navigate("signin")
                    } else {
                        Log.d("AUTH","Failed: ${task.exception}")
                    }
                }
        }
    ) {
        Text("Sign Up")
    }
}

@Composable
fun DividerWithText(text: String) {
    Row(
        modifier = Modifier.padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f))
        Text(text, modifier = Modifier.padding(horizontal = 8.dp))
        Divider(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SignUpWithGoogleButton() {
    OutlinedButton(
        onClick = { /* Handle Google sign up */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = "Sign up with Google",
            modifier = Modifier.size(24.dp),
            tint = androidx.compose.ui.graphics.Color.Unspecified
        )
        Spacer(Modifier.width(8.dp))
        Text("Sign up with Google")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}