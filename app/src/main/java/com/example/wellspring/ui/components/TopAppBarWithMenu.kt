package com.example.wellspring.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import androidx.compose.material.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(navController: NavHostController) {
    var showMenu by remember { mutableStateOf(false) }

    MediumTopAppBar(
        title = { Text("Your App Name") },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        showMenu = false
                    },
                    text = { Text("Dark Mode") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dark_mode),
                            contentDescription = "Dark Mode"
                        )
                    }
                )
                DropdownMenuItem(
                    onClick = {
                        // Sign out logic
                        showMenu = false
                        navController.navigate("signin")
                    },
                    text = { Text("Sign Out") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_signout),
                            contentDescription = "Sign Out"
                        )
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarWithMenu() {
    val navController = rememberNavController()
    TopAppBarWithMenu(navController)
}