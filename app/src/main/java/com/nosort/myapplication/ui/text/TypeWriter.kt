package com.nosort.myapplication.ui.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TypeWriterText() {

    val textToDisplay = remember {
        mutableStateOf("Hello Android")
    }
    val count = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = count.value) {
        textToDisplay.value.forEachIndexed { index, _ ->
            textToDisplay.value = "Hello Android".substring(0, index + 1)
            delay(200)
        }
    }

    Column {
        BasicText(
            text = textToDisplay.value,
            style = TextStyle(
                color = Color.Red,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        )
        Button(onClick = {
            count.value += 1
        }) {
            BasicText(text = "Start Again")
        }
    }

}