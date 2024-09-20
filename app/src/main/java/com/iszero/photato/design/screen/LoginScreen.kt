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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iszero.photato.design.component.AuthTextField
import com.iszero.photato.design.component.BackScreenButton
import com.iszero.photato.design.component.BaseButton
import com.iszero.photato.ui.theme.pretendard

@Composable
fun LoginScreen(modifier: Modifier){
    Box(
        modifier
            .fillMaxSize()
            .background(Color(0xFFFFD66C)),
        contentAlignment = Alignment.Center
    ){
        BackScreenButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 15.dp, y = 20.dp),
            onClick = {TODO()}
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
                placeholder = "이름을 입력해주세요",
                keyboardType = KeyboardType.Text
            )
            AuthTextField(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 120.dp),
                placeholder = "비밀번호를 입력해주세요",
                keyboardType = KeyboardType.Password,
                password = true
            )
        }
        BaseButton(
            text = "로그인",
            onClick = { /*TODO*/ },
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
fun LoginScreenPreview() {
    LoginScreen(modifier = Modifier.fillMaxSize())
}

