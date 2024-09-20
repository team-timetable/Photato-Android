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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iszero.photato.R
import com.iszero.photato.design.component.AuthTextField
import com.iszero.photato.design.component.BackScreenButton
import com.iszero.photato.design.component.BaseButton
import com.iszero.photato.ui.theme.pretendard

@Composable
fun SignupScreen(modifier: Modifier){
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
            var nameText by remember { mutableStateOf("") }
            var passwordText by remember { mutableStateOf("") }
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
        }
        BaseButton(
            text = "회원가입",
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
fun SignupScreenPreview() {
    SignupScreen(modifier = Modifier.fillMaxSize())
}
