package com.iszero.photato.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iszero.photato.R
import com.iszero.photato.ui.theme.pretendard

@Composable
fun BackScreenButton(
    modifier: Modifier,
    onClick: () -> Unit,
    color: Color
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
            colorFilter = ColorFilter.tint(color)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "뒤로가기",
            color = color,
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
    BackScreenButton(modifier = Modifier,color = Color.Black,onClick = {})
}
