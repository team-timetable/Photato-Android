package com.iszero.photato.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.unit.dp
import com.iszero.photato.ui.theme.pretendard

@Composable
fun BaseButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.07f)
            .background(color = Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp)) // 연한 배경색
    ) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            colors = buttonColors(containerColor = backgroundColor),
            modifier = Modifier.fillMaxSize()
                .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false,
                ambientColor = Color(0xFFE5E5E5),
                spotColor = Color(0xFFE5E5E5)
            )
        ) {
            Text(
                text = text,
                color = textColor,
                fontFamily = pretendard,
                fontWeight = Light
            )
        }
    }
}