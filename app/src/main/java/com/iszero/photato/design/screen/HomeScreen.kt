package com.iszero.photato.design.screen

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iszero.photato.design.component.BottomNavigationBar
import com.iszero.photato.nav.currentRoute

@Composable
fun HomeScreen(navController: NavHostController) {
    val currentRoute = currentRoute(navController)
    Scaffold(
        bottomBar = {
            if (currentRoute in listOf("home", "my")) {
                BottomNavigationBar(navController)
            }
        }
    ){
    }
    Text(text = "home",
        fontSize = 30.sp)
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavHostController(androidx.compose.ui.platform.LocalContext.current))
}
