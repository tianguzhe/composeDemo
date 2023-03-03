package com.example.studydemo.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.studydemo.utils.floorMod

/**
 * 轮播图指示器
 *
 * */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    count: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
    indicatorWidth: Dp = 8.dp,
    indicatorHeight: Dp = indicatorWidth,
    spacing: Dp = indicatorWidth,
    indicatorShape: Shape = CircleShape,
) {
    val indicatorWidthPx = LocalDensity.current.run { indicatorWidth.roundToPx() }
    val spacingPx = LocalDensity.current.run { spacing.roundToPx() }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val indicatorModifier = Modifier.size(width = indicatorWidth, height = indicatorHeight)
                .background(color = inactiveColor, shape = indicatorShape)

            repeat(count) {
                Box(indicatorModifier)
            }
        }

        Box(
            Modifier.offset {
                val scrollPosition =
                    ((pagerState.currentPage - Int.MAX_VALUE / 2).floorMod(count) + pagerState.currentPageOffsetFraction).coerceIn(
                        0f,
                        (count - 1).coerceAtLeast(0).toFloat(),
                    )
                IntOffset(
                    x = ((spacingPx + indicatorWidthPx) * scrollPosition).toInt(),
                    y = 0,
                )
            }.size(width = indicatorWidth, height = indicatorHeight).background(
                color = activeColor,
                shape = indicatorShape,
            ),
        )
    }
}
