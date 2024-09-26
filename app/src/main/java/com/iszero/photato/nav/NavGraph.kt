package com.iszero.photato.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iszero.photato.design.screen.HomeScreen
import com.iszero.photato.design.screen.IntroScreen
import com.iszero.photato.design.screen.LoginScreen
import com.iszero.photato.design.screen.MyScreen
import com.iszero.photato.design.screen.SignupScreen

@Composable
fun NavGraph(navController: NavHostController) {
    val startDestination = if (true) NavGroup.HOME else NavGroup.INTRO

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = NavGroup.INTRO) {
            IntroScreen(navController = navController)
        }
        composable(route = NavGroup.LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(route = NavGroup.SIGNUP) {
            SignupScreen(navController = navController)
        }
        composable(route = NavGroup.HOME) {
            HomeScreen(navController = navController)
        }
        composable(route = NavGroup.MY) {
            MyScreen(navController = navController)
        }
    }
}
