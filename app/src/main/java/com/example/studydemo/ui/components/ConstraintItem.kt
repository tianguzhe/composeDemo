package com.example.studydemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.example.studydemo.R

/**
 * 约束布局
 *
 * */
@Composable
fun ConstraintItem(modifier: Modifier = Modifier, debugger: Boolean = false) {
    val constraints = ConstraintSet {
        val cover = createRefFor("cover")
        val title = createRefFor("title")
        val type = createRefFor("type")
        val time = createRefFor("time")

        constrain(cover) {
            width = Dimension.value(150.dp)
            start.linkTo(parent.start, margin = 8.dp)
        }
        constrain(title) {
            width = Dimension.fillToConstraints
            start.linkTo(cover.end, margin = 8.dp)
            end.linkTo(parent.end, margin = 8.dp)
        }
        constrain(type) {
            start.linkTo(title.start)
            bottom.linkTo(cover.bottom)
        }
        constrain(time) {
            end.linkTo(title.end, margin = 8.dp)
            top.linkTo(type.top)
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth().then(modifier)) {
        Image(
            painter = if (debugger) {
                painterResource(id = R.mipmap.p456482220)
            } else {
                rememberAsyncImagePainter(
                    model = "https://img1.doubanio.com/view/photo/m/public/p456482220.jpg",
                )
            },
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(16 / 9f).clip(RoundedCornerShape(4.dp))
                .layoutId("cover"),
        )

        Text(
            "行测老师教你如何制定学习方案测老师教你如,行测老师教你如何制定学习方案",
            color = Color(0xFF666666),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("title"),
        )

        Text(
            "视频课程",
            color = Color(0xFF999999),
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("type"),
        )

        Text(
            "时长: 20:02:05",
            color = Color(0xFF999999),
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("time"),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VideoScreenPreview() {
    ConstraintItem(debugger = true)
}
