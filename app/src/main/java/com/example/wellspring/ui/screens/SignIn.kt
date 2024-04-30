package com.example.wellspring

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()
        Spacer(Modifier.height(16.dp))
        Headline()
        SupportingText()
        Spacer(Modifier.height(32.dp))
        EmailInput()
        Spacer(Modifier.height(16.dp))
        PasswordInput()
        Spacer(Modifier.height(24.dp))
        SignInButton()
        SignUpButton()
        DividerWithText()
        SignInWithGoogleButton()
    }
}

@Composable
fun Logo() {
    val image: Painter = painterResource(id = R.drawable.logo_wellspring)
    Image(
        painter = image,
        contentDescription = "Logo",
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun Headline() {
    Text("Sign in", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun SupportingText() {
    Text("with your Wellspring Account", style = MaterialTheme.typography.bodyLarge)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Email Address") },
        singleLine = true,
        modifier = Modifier.padding(horizontal = 42.dp),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Enter your password") },
        singleLine = true,
        modifier = Modifier.padding(horizontal = 42.dp),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { /* Handle the action here */ })
    )
}

@Composable
fun SignInButton() {
    Button(
        onClick = { /* Handle sign in */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 42.dp)
    ) {
        Text("Sign in")
    }
}

@Composable
fun SignUpButton() {
    Button(
        onClick = { /* Handle sign up */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 42.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text("Sign up")
    }
}

@Composable
fun DividerWithText() {
    Row(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 42.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f))
        Text(" OR ", modifier = Modifier.padding(horizontal = 8.dp))
        Divider(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SignInWithGoogleButton() {
    OutlinedButton(
        onClick = { /* Handle Google sign in */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 42.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Google sign in",
            modifier = Modifier.size(24.dp),
            tint = androidx.compose.ui.graphics.Color.Unspecified // Display the icon in its original color
        )
        Spacer(Modifier.width(8.dp))  // Space between icon and text
        Text("Sign in with Google")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen()
}

