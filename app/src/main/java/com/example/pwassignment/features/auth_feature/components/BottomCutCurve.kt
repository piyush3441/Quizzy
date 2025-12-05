package com.example.pwassignment.features.auth_feature.components

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class BottomCutCurve : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height * 0.85f)
            quadraticTo(width / 2, height, width, height * 0.85f)
            lineTo(width, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}