package com.iszero.photato.design.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iszero.photato.R
import com.iszero.photato.nav.currentRoute


@Composable
fun BottomNavigationBar (navController: NavController){
    Card(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        elevation = 16.dp,
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxHeight(0.14f)
    ) {
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            BottomNavigationItem(
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                icon = {
                    Box(
                        modifier = Modifier.padding(bottom = 4.dp)
                    ) {
                        Icon(
                            painterResource(R.drawable.home),
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp),
                            tint = if (currentRoute(navController) == "home") Color.Black else Color(
                                0xFFCCCCCC
                            )

                        )
                    }
                },
                label = {
                    Box(modifier = Modifier.padding(top = 4.dp))
                        Text(
                            text = "홈",
                            color = if (currentRoute(navController) == "home") Color.Black else Color(
                                0xFF6E6E6E
                            )
                        )
                    },
                selected = currentRoute(navController) == "home",
                onClick = { navController.navigate("home") }
            )
            BottomNavigationItem(
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                icon = {
                    Box(
                        modifier = Modifier.padding(bottom = 4.dp)
                    ) {
                        Icon(
                            painterResource(R.drawable.add_photo),
                            contentDescription = "Camera",
                            modifier = Modifier.size(50.dp),
                            tint = Color.Unspecified
                        )
                    }
                },
                selected = currentRoute(navController) == "camera",
                onClick = { navController.navigate("camera") }
            )
            BottomNavigationItem(
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                icon = {
                    Box(
                        modifier = Modifier.padding(bottom = 4.dp)
                    ) {
                        Icon(
                            painterResource(R.drawable.my),
                            contentDescription = "My",
                            modifier = Modifier.size(24.dp),
                            tint = if (currentRoute(navController) == "my") Color.Black else Color(
                                0xFFCCCCCC
                            )
                        )
                    }
                },
                label = {
                    Box(modifier = Modifier.padding(top = 4.dp)) {
                        Text(
                            text = "마이",
                            color = if (currentRoute(navController) == "my") Color.Black else Color(
                                0xFF6E6E6E
                            )
                        )
                    }
                },
                selected = currentRoute(navController) == "my",
                onClick = { navController.navigate("my") }
            )
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BottomNavigationBarPreview(
) {
    BottomNavigationBar(navController = NavController(LocalContext.current))
}