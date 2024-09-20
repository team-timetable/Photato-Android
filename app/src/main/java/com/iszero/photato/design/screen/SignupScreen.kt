package com.iszero.photato.design.screen

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
import com.iszero.photato.R
import com.iszero.photato.another.sameCheck
import com.iszero.photato.design.component.AuthTextField
import com.iszero.photato.design.component.BackScreenButton
import com.iszero.photato.design.component.BaseButton
import com.iszero.photato.nav.NavGroup
import com.iszero.photato.server.api.auth.signup
import com.iszero.photato.ui.theme.pretendard
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun SignupScreen(navController: NavHostController){
    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD66C)),
        contentAlignment = Alignment.Center
    ){
        var nameText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }
        var rePasswordText by remember { mutableStateOf("") }
        var errorMessage by remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()
        BackScreenButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 15.dp, y = 20.dp),
            onClick = {navController.navigate(NavGroup.INTRO)}
        )
        Text(
            text = "회원가입",
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
                keyboardType = KeyboardType.Text,
                text = nameText,
                onTextChange = { newText -> nameText = newText },
                icon = R.drawable.plant_un_fill
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
                password = true,
                icon = R.drawable.plant_un_fill
            )
            AuthTextField(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 200.dp),
                mediumHolder = "비밀번호",
                lightHolder = "를 다시입력해주세요",
                keyboardType = KeyboardType.Password,
                text = rePasswordText,
                onTextChange = { newText -> rePasswordText = newText },
                password = true,
                icon = R.drawable.plant_un_fill
            )
            Text(
                text = errorMessage,
                modifier = Modifier.align(Alignment.TopCenter).offset(y = (260).dp),
                color = Color.Red
            )
        }
        BaseButton(
            text = "회원가입",
            onClick = {
                coroutineScope.launch {
                    if (passwordText.length >= 8) {
                        if (sameCheck(passwordText, rePasswordText)) {
                            val signupResult = signup(username = nameText, password = passwordText)
                            if (signupResult != null) {
                                // UI 작업은 메인 스레드에서 처리
                                navController.navigate(NavGroup.LOGIN)
                            } else {
                                errorMessage = "다시 시도해주세요"
                            }
                        } else {
                            errorMessage = "비밀번호가 일치하지 않습니다"
                        }
                    } else {
                        errorMessage = "비밀번호는 8자 이상이어야 합니다"
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = -40.dp),
            backgroundColor = Color(0xFFFFD66C)
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun SignupScreenPreview() {
    SignupScreen(navController = NavHostController(LocalContext.current))
}

