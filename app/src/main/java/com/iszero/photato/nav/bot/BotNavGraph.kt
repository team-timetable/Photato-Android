package com.iszero.photato.nav.bot

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iszero.photato.design.screen.HomeScreen
import com.iszero.photato.design.screen.MyScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BotNavItem.Home.screenRoute) {
        composable(BotNavItem.Home.screenRoute) {
            HomeScreen()
        }
        composable(BotNavItem.My.screenRoute) {
            MyScreen()
        }
    }
}