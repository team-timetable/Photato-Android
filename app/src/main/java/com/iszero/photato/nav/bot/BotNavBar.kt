package com.iszero.photato.nav.bot

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iszero.photato.nav.bot.BotNavItem.Home.screenRoute

@Composable
fun BotNavBar (){
    val items = listOf(
        BotNavItem.Home,
        BotNavItem.My
    )
    val navBackStackEntry by rememberNavController().currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navController = rememberNavController()
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF3F414E)
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = BotNavItem.Home.icon),
                    contentDescription = stringResource(id = BotNavItem.Home.title),
                    modifier = Modifier
                        .width(26.dp)
                        .height(26.dp)
                )
            },
            label = { Text(stringResource(id = BotNavItem.Home.title), fontSize = 9.sp) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = Gray,
            selected = currentRoute == screenRoute,
            alwaysShowLabel = false,
            onClick = {
                navController.navigate(BotNavItem.Home.screenRoute) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(it) { saveState = true }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )


        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = BotNavItem.My.icon),
                    contentDescription = stringResource(id = BotNavItem.My.title),
                    modifier = Modifier
                        .width(26.dp)
                        .height(26.dp)
                )
            },
            label = { Text(stringResource(id = BotNavItem.My.title), fontSize = 9.sp) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = Gray,
            selected = currentRoute == screenRoute,
            alwaysShowLabel = false,
            onClick = {
                navController.navigate(BotNavItem.My.screenRoute) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(it) { saveState = true }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

    }
}