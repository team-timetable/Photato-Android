package com.iszero.photato.design.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iszero.photato.R
import com.iszero.photato.design.component.BaseButton

@Composable
fun IntroScreen(modifier: Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color(0xFFFFD66C)),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.foundation.Canvas(
            modifier = modifier.fillMaxSize()
        ) {
            val ovalWidth = size.width * 2f
            val ovalHeight = size.height * 0.8f
            drawOval(
                color = Color.White,
                topLeft = Offset(
                    (size.width - ovalWidth) / 2,
                    size.height - (ovalHeight / 1.5f)
                ),
                size = Size(ovalWidth, ovalHeight)
            )
        }
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .offset(y = (-60).dp),
            contentDescription = "Photato Logo",
            painter = painterResource(id = R.drawable.photato_logo),
        )
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .offset(y = 40.dp),
            contentDescription = "Photato Logo Text",
            painter = painterResource(id = R.drawable.photato_logo_text),
        )
        BaseButton(text = "로그인",
            onClick = { /*TODO*/ },
            backgroundColor = Color(0xFFFFD66C),
            textColor = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-110).dp)
                .shadow(
                    elevation = 0.5.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = false,
                    ambientColor = Color(0xFFFAFAFA),
                    spotColor = Color(0xFFFAFAFA)

                )
        )
        BaseButton(text = "회원가입",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-40).dp)
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun IntroScreenPreview() {
    IntroScreen(modifier = Modifier.fillMaxSize())
}
