package com.iszero.photato.design.screen

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iszero.photato.design.component.BottomNavigationBar
import com.iszero.photato.nav.currentRoute

@Composable
fun MyScreen(navController: NavController){
    val currentRoute = currentRoute(navController)
    Scaffold(
        bottomBar = {
            if (currentRoute in listOf("home", "my")) {
                BottomNavigationBar(navController)
            }
        }
    ){
    }
    Text(text = "my",
        fontSize = 30.sp)
}