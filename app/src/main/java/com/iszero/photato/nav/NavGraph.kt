package com.iszero.photato.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iszero.photato.design.screen.IntroScreen
import com.iszero.photato.design.screen.LoginScreen
import com.iszero.photato.design.screen.SignupScreen

@Composable
fun NavGraph(navController : NavHostController){
    NavHost(navController = navController, startDestination = NavGroup.INTRO) {
        composable(route = NavGroup.INTRO){
            IntroScreen(navController = navController)
        }
        composable(route = NavGroup.LOGIN){
            LoginScreen(navController = navController)
        }
        composable(route = NavGroup.SIGNUP){
            SignupScreen(navController = navController)
        }

    }
}