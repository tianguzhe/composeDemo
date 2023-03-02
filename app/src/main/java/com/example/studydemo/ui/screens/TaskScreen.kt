package com.example.studydemo.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.studydemo.mock.MovieItem
import com.example.studydemo.ui.components.AppBar
import com.example.studydemo.ui.components.HorizontalPagerIndicator
import com.example.studydemo.ui.screens.viewmodel.TaskViewModel
import com.example.studydemo.utils.floorMod

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskScreen(vm: TaskViewModel = viewModel()) {
    val movieData by vm.movieData.collectAsStateWithLifecycle()

    Column {
        AppBar {
            Text("Top250", color = Color.White, fontSize = 20.sp)
        }

        LazyColumn(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(
                horizontal = 8.dp,
            ),
        ) {
            itemsIndexed(movieData.items) { lazyIndex, movie ->
                if (lazyIndex == 0) Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            AsyncImage(
                                model = movie.pic.large,
                                contentDescription = null,
                                modifier = Modifier.size(
                                    100.dp,
                                    160.dp,
                                ).clip(RoundedCornerShape(6.dp)),
                                contentScale = ContentScale.Crop,
                            )
                            Spacer(modifier = Modifier.width(16.dp))

                            // Display
                            val pageCount = movie.photos.size

                            // We start the pager in the middle of the raw number of pages
                            val startIndex = Int.MAX_VALUE / 2
                            val pagerState = rememberPagerState(initialPage = startIndex)

                            Box {
                                HorizontalPager(
                                    pageCount = Int.MAX_VALUE,
                                    state = pagerState,
                                ) { index ->
                                    AsyncImage(
                                        model = movie.photos[
                                            (index - startIndex).floorMod(
                                                pageCount,
                                            ),
                                        ],
                                        contentDescription = null,
                                        modifier = Modifier.size(
                                            300.dp,
                                            160.dp,
                                        ).clip(RoundedCornerShape(6.dp)),
                                        contentScale = ContentScale.Crop,
                                    )
                                }

                                HorizontalPagerIndicator(
                                    pagerState = pagerState,
                                    count = 4,
                                    indicatorWidth = 6.dp,
                                    activeColor = Color.White,
                                    inactiveColor = Color.Gray,
                                    modifier = Modifier.align(
                                        Alignment.BottomCenter,
                                    ).padding(bottom = 8.dp),
                                )
                            }
                        }
                        MovieCardDetail(movie)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieCardDetail(movie: MovieItem) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = movie.rating.value.toString(), color = Color(0xFFF19116))
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = movie.cardSubtitle,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray,
            modifier = Modifier.width(
                width = 350.dp,
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = movie.description, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(30.dp))
    }
}
