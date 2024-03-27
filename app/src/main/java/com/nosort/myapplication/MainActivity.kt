package com.nosort.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nosort.myapplication.ui.text.FoundationText
import com.nosort.myapplication.ui.text.Material3Text
import com.nosort.myapplication.ui.text.TypeWriterText
import com.nosort.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val anim = rememberInfiniteTransition(label = "hello_world_inifinite")
    val firstColor = anim.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(400),
            repeatMode = RepeatMode.Reverse
        ),
        label = "first_color"
    )
    val secondColor = anim.animateColor(
        initialValue = Color.Blue, targetValue = Color.Magenta,
        animationSpec = infiniteRepeatable(
            animation = tween(400),
            repeatMode = RepeatMode.Reverse
        ),
        label = "second_color"
    )
    val thirdColor = anim.animateColor(
        initialValue = Color.Magenta,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(400),
            repeatMode = RepeatMode.Reverse
        ),
        label = "third_color",
    )
    val skewX = anim.animateFloat(
        initialValue = -0.5f, targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "skew_x"
    )
    val letterSpacingSpanEm = anim.animateFloat(
        initialValue = 0f, targetValue = 0.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "letter_spacing"
    )

    val fontWeightSpec = anim.animateFloat(
        initialValue = 300f, targetValue = 800f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "letter_spacing"
    )
    val fontSizeSpec = anim.animateFloat(
        initialValue = 36f, targetValue = 60f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "letter_spacing"
    )

    Column {

        TypeWriterText()

        FoundationText(
            name,
            fontSizeSpec.value,
            fontWeightSpec.value,
            firstColor.value,
            secondColor.value,
            thirdColor.value,
            letterSpacingSpanEm.value,
            skewX.value
        )

        Spacer(modifier = Modifier.height(16.dp))

        Material3Text(
            name,
            fontSizeSpec.value,
            fontWeightSpec.value,
            firstColor.value,
            secondColor.value,
            thirdColor.value,
            letterSpacingSpanEm.value,
            skewX.value
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}