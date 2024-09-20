package com.iszero.photato.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iszero.photato.R
import com.iszero.photato.ui.theme.pretendard
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    modifier: Modifier,
    mediumHolder : String,
    lightHolder: String,
    keyboardType: KeyboardType,
    password : Boolean = false,
    icon : Int = R.drawable.plant_fill
){
    Box(
        modifier
            .fillMaxWidth(0.8f)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false,
                ambientColor = Color(0xFFE5E5E5),
                spotColor = Color(0xFFE5E5E5)
            )
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(8.dp)
            )
    )
        {
        Row(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(
                    id = icon
                ),
                contentDescription = "AuthImage",
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.CenterVertically)
            )
            var text by remember { mutableStateOf("") }
            TextField(
                value = text, onValueChange = { text = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color(0xFFFFFFFF),
                    cursorColor = Color(0xFF000000),
                ),
                visualTransformation =
                if (password) {
                    PasswordVisualTransformation()  // 비밀번호면 텍스트를 숨김
                }
                else
                {
                    VisualTransformation.None       // 비밀번호가 아니면 그대로 보임
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                ),
                maxLines = 1,
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color(0xFF000000),
                    fontSize = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold
                ),
                placeholder = {
                    Row{
                    Text(
                        text = mediumHolder,
                        color = Color.Gray,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = lightHolder,
                        color = Color.Gray,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Light
                    )
                }
                }
            )
        }

    }
}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun AuthTextFieldPreview(){
    AuthTextField(modifier = Modifier, mediumHolder = "테스트", lightHolder = "글귀다 이것들아", keyboardType = KeyboardType.Password)
}