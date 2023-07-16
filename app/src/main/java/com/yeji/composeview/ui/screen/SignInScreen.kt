package com.yeji.composeview.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yeji.composeview.R
import com.yeji.composeview.ui.theme.MainColor
import com.yeji.composeview.ui.viewmodel.SignInViewModel

@Composable
fun SignInScreen() {
    SignInContent()
}

@Preview(showBackground = true)
@Composable
fun SignInContent() {
    val vm: SignInViewModel = hiltViewModel()

    Row(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.5f),
            verticalArrangement = Arrangement.Center
        ) {
            SignInTitle()
            Spacer(modifier = Modifier.height(5.dp))
            SignInSubtitle()
            Spacer(modifier = Modifier.height(35.dp))
            TextInputBox(
                InputStatus.EMAIL,
                onTextChange = {
                    vm.email(it)
                })
            Spacer(modifier = Modifier.height(15.dp))
            SignInNextButton(
                onNext = {
                    vm.signIn(vm.email())
                })
        }
        Spacer(modifier = Modifier.width(20.dp))
    }
}

@Composable
fun SignInTitle() {
    Text(
        text = stringResource(id = R.string.login_title),
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SignInSubtitle() {
    Text(
        text = stringResource(id = R.string.login_subtitle),
        color = Color.Black,
        fontSize = 15.sp,
    )
}

@Composable
fun TextInputBox(type: InputStatus, onTextChange: (text: String) -> Unit) {
    var text by remember { mutableStateOf("") }

    val option: KeyboardOptions = when (type) {
        InputStatus.EMAIL -> {
            KeyboardOptions(keyboardType = KeyboardType.Email)
        }

        InputStatus.PASS -> {
            KeyboardOptions(keyboardType = KeyboardType.Password)
        }
    }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            onTextChange(it)
        },
        textStyle = TextStyle(
            fontSize = 15.sp
        ),
        keyboardOptions = option,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(15.dp)
            ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.padding(20.dp, 15.dp)
            ) {
                if (text.isEmpty()) {
                    Text(
                        text = stringResource(id = R.string.email_hint),
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                }
                innerTextField()
            }
        }
    )
}

@Composable
fun SignInNextButton(onNext: () -> Unit) {
    Button(
        onClick = {
            onNext()
        },
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainColor,
            contentColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(20.dp, 15.dp),
    ) {
        Text(text = stringResource(id = R.string.next))
    }
}

enum class InputStatus {
    EMAIL, PASS
}