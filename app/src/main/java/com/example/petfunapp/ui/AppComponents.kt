package com.example.petfunapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petfunapp.R

@Composable
fun TopBar(value:String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = value
            , color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Usman Pet App"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopbarPreview(){
    TopBar("")
}

@Composable
fun TextComponent(textValue:String,textSize :TextUnit, colorvalue: Color= Color.Black){
    Text(text = textValue, fontSize = textSize,color=colorvalue, fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentView(){
    TextComponent(textValue = "Native", textSize = 24.sp)
}

@Composable
fun TextFieldComponent(
    onTextChanged : (name:String) -> Unit
){
    var currentValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue ,
        onValueChange ={
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        )
    )
}


@Preview
@Composable
fun PreviewTextField(){
    TextFieldComponent(onTextChanged = {})
}