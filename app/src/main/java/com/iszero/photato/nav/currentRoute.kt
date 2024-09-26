package com.iszero.photato.nav

import androidx.navigation.NavController

fun currentRoute(navController: NavController): String?{
    return navController.currentBackStackEntry?.destination?.route
}