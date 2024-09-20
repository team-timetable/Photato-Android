package com.iszero.photato.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iszero.photato.R
import com.iszero.photato.design.screen.IntroScreen
import com.iszero.photato.ui.theme.pretendard

@Composable
fun BackScreenButton(
    modifier: Modifier,
    onClick: () -> Unit,
)
{
    Row(
        modifier.
        clickable(onClick = onClick) // 클릭 가능하게 만듦
            .background(Color.Transparent) // 원하는 배경색 설정
            .padding(0.dp) // 패딩 제거
            .wrapContentSize()
        )
    {
        Image(
            modifier = Modifier.align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.back_button),
            contentDescription = "Back Button",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "뒤로가기",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold
        )
    }
}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun BackScreenButtonPreview() {
    BackScreenButton(modifier = Modifier,onClick = {})
}
