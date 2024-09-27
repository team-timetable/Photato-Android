package com.iszero.photato.design.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iszero.photato.design.component.BottomNavigationBar
import com.iszero.photato.nav.currentRoute

@Composable
fun MyScreen(navController: NavController){
    val currentRoute = currentRoute(navController)
    Scaffold(
        bottomBar = {
            if (currentRoute in listOf("home", "my","camera")) {
                BottomNavigationBar(navController)
            }
        }
    ){ innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Text(
                text = "my",
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}