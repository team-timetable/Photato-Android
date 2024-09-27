package com.iszero.photato.design.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iszero.photato.design.component.BackScreenButton
import com.iszero.photato.nav.NavGroup
import com.iszero.photato.nav.currentRoute


@Composable
fun CameraScreen(navController: NavHostController) {
    val currentRoute = currentRoute(navController)
    Scaffold(
        Modifier.background(Color.White)
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
        BackScreenButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 15.dp, y = 20.dp),
            onClick = { navController.navigate(NavGroup.HOME) },
            color = Color.Black
        )
    }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Text(
                text = "camera",
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CameraScreenPreview() {
    CameraScreen(navController = NavHostController(androidx.compose.ui.platform.LocalContext.current))
}