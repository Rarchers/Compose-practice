package com.example.compose.ui.login



import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.compose.MyViewModel
import com.example.compose.ui.theme.purplish
import com.example.compose.R
import com.example.compose.ui.WeChat
import com.example.compose.ui.theme.forgot
import com.example.compose.ui.theme.orangish
import com.example.compose.ui.theme.shapes


@ExperimentalMaterialApi
@Composable
fun loginPage(context: Context) {
    val myViewModel:MyViewModel = viewModel()
    myViewModel.num = 1
    Box {
        val text = annotatedString {
            append("Don`t have account?")
            withStyle(SpanStyle(color = Color.Yellow)){
                append("Sign up here")
            }
        }

        Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.CenterHorizontally) {
                Row() {
                    Image(imageResource(id = R.drawable.done),modifier = Modifier.size(80.dp))
                }

                Text(text = text, color = Color.White)
                Spacer(modifier = Modifier.padding(6.dp))
            }
        }
        MainCard(context)

    }
}

@ExperimentalMaterialApi
@Composable
fun MainCard(context: Context){
    val email = remember { mutableStateOf(TextFieldValue("Rarcher@gmil.com")) }
    val passState = remember { mutableStateOf(TextFieldValue("")) }
    val modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)

    Surface(color = Color.White,modifier = Modifier
            .preferredHeight(600.dp)
            .fillMaxWidth()
            ,shape = RoundedCornerShape(60.dp).copy(topLeft = ZeroCornerSize,topRight = ZeroCornerSize)) {
        Column(modifier = Modifier.padding(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
            Image(imageResource(id = R.drawable.you_define_me))

            Spacer(modifier = Modifier.padding(16.dp))
            OutlinedTextField(value = email.value, onValueChange = { email.value = it },label = {
                Text(text = "Email")
            },leadingIcon = {Icon(Icons.Filled.Email)},modifier = modifier)

            Spacer(modifier = Modifier.padding(12.dp))

            OutlinedTextField(value = passState.value, onValueChange = { passState.value = it },label = {
                Text(text = "Password")
            },leadingIcon = {Icon(Icons.Filled.Lock)}, modifier = modifier,
                    keyboardOptions = KeyboardOptions(capitalization =  KeyboardCapitalization.None,autoCorrect= true,keyboardType = KeyboardType.Password,imeAction = ImeAction.Unspecified))

            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            ProvideEmphasis(emphasis = AmbientEmphasisLevels.current.disabled) {
                Text(text = "Forgot Password?",textAlign = TextAlign.End,modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),color = forgot)
            }

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Button(onClick = {
                             context.startActivity(Intent(context,WeChat::class.java))
            },colors = object : ButtonColors{
                override fun backgroundColor(enabled: Boolean): Color {
                    return orangish
                }
                override fun contentColor(enabled: Boolean): Color {
                    return Color.White
                }
            },shape = shapes.medium,modifier = modifier) {
                Text(text = "Login")
            }

        }
    }
}


