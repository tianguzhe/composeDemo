package com.example.studydemo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 圆形进度条
 *
 * */
@Composable
fun CircleRing(
    maxValue: Number,
    value: Number,
    modifier: Modifier = Modifier,
) {
    val sweepAngle = (value.toFloat() * 270f) / maxValue.toFloat()
    val style: DrawStyle = Stroke(30f, cap = StrokeCap.Round)

    Canvas(modifier = modifier) {
        drawArc(
            color = Color(0, 0, 0, 33),
            startAngle = 135f,
            sweepAngle = 270f,
            useCenter = false,
            style = style,
        )
        drawArc(
            color = Color(0xFFFD8A3D),
            startAngle = 135f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = style,
        )
    }
}

@Preview
@Composable
fun CircleRingPreviewTo30() {
    CircleRing(100, 30, modifier = Modifier.size(100.dp).padding(8.dp))
}

@Preview
@Composable
fun CircleRingPreviewTo70() {
    CircleRing(100, 70)
}
