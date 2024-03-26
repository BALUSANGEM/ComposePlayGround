package com.nosort.myapplication

import android.graphics.DiscretePathEffect
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toComposePathEffect
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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


@OptIn(ExperimentalTextApi::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


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

    Text(
        text = "Hello \n$name!",
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = fontSizeSpec.value.sp,
            fontWeight = FontWeight(fontWeightSpec.value.toInt()),
            shadow = Shadow(
                color = Color.DarkGray,
                offset = Offset(10f, 15f),
                blurRadius = 10f
            ),
            brush = Brush.horizontalGradient(
                0.0f to firstColor.value,
                0.3f to secondColor.value,
                0.7f to thirdColor.value
            ),
            letterSpacing = TextUnit(value = letterSpacingSpanEm.value, type = TextUnitType.Em),
            textDecoration = TextDecoration.Underline,
            textGeometricTransform = TextGeometricTransform(1f, skewX.value),
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}