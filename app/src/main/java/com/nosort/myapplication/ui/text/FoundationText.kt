package com.nosort.myapplication.ui.text

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

@Composable
@OptIn(ExperimentalTextApi::class)
fun FoundationText(
    name: String,
    fontSizeSpec: Float,
    fontWeightSpec: Float,
    firstColor: Color,
    secondColor: Color,
    thirdColor: Color,
    letterSpacingSpanEm: Float,
    skewX: Float
) {
    BasicText(
        text = "From\nFoundation\n$name!",
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = fontSizeSpec.sp,
            fontWeight = FontWeight(fontWeightSpec.toInt()),
            shadow = Shadow(
                color = Color.DarkGray,
                offset = Offset(10f, 15f),
                blurRadius = 10f
            ),
            brush = Brush.horizontalGradient(
                0.0f to firstColor,
                0.3f to secondColor,
                0.7f to thirdColor
            ),
            letterSpacing = TextUnit(value = letterSpacingSpanEm, type = TextUnitType.Em),
            textDecoration = TextDecoration.Underline,
            textGeometricTransform = TextGeometricTransform(1f, skewX),
        ),
    )
}