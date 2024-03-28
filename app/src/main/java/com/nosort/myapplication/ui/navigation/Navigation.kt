package com.nosort.myapplication.ui.navigation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nosort.myapplication.ui.Home
import com.nosort.myapplication.ui.text.FoundationText
import com.nosort.myapplication.ui.text.Material3Text
import com.nosort.myapplication.ui.text.TypeWriterText

@Composable
fun Navigation(name: String) {

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

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("foundation_text") {
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
        }
        composable("material3_text") {
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

        composable("type_writer_text") {
            TypeWriterText()

        }
        composable("home") {
            Home(navController)
        }
    }


}