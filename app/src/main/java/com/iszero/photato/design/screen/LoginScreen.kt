package com.iszero.photato.design.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iszero.photato.design.component.AuthTextField
import com.iszero.photato.design.component.BackScreenButton
import com.iszero.photato.design.component.BaseButton
import com.iszero.photato.nav.NavGroup
import com.iszero.photato.server.api.auth.login
import com.iszero.photato.server.data.auth.AuthResponse
import com.iszero.photato.ui.theme.pretendard
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD66C)),
        contentAlignment = Alignment.Center
    ){
        var nameText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }
        var errorMessage by remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()
        val context = LocalContext.current
        BackScreenButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 15.dp, y = 20.dp),
            onClick = {navController.navigate(NavGroup.INTRO)},
            color = Color.White
        )
        Text(
            text = "로그인",
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = (150).dp),
            fontFamily = pretendard,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.8f)
                .offset(y = 70.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White)
        ){

            AuthTextField(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 40.dp),
                mediumHolder = "이름",
                lightHolder = "을 입력해주세요",
                text = nameText,
                onTextChange = { newText -> nameText = newText },
                keyboardType = KeyboardType.Text
            )
            AuthTextField(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 120.dp),
                mediumHolder = "비밀번호",
                lightHolder = "를 입력해주세요",
                keyboardType = KeyboardType.Password,
                text = passwordText,
                onTextChange = { newText -> passwordText = newText },
                password = true
            )

            Text(
                text = errorMessage,
                modifier = Modifier.align(Alignment.TopCenter).offset(y = (180).dp),
                color = Color.Red
            )
        }
        BaseButton(
            text = "로그인",
            onClick = {
                coroutineScope.launch{
                    val loginResult: AuthResponse? =
                        login(
                            username = nameText,
                            password = passwordText,
                            context = context
                        )
                    if (loginResult != null){
                        Log.d("로그인확인","로그인성공")
                        navController.navigate(NavGroup.HOME)
                    }
                    else{
                        Log.d("로그인확인","로그인실패")
                        errorMessage = "다시 로그인해주세요"
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-40).dp),
            backgroundColor = Color(0xFFFFD66C)
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun LoginScreenPreview() {
    LoginScreen(navController = NavHostController(LocalContext.current))
}

