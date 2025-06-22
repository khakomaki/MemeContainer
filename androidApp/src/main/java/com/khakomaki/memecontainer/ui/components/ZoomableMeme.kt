package com.khakomaki.memecontainer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import coil3.compose.rememberAsyncImagePainter

@Composable
fun ZoomableMeme(imagePath: String, modifier: Modifier = Modifier) {
    val zoomedInScale = 2f
    val zoomedOutScale = 1f

    var scale by remember { mutableFloatStateOf(1f) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var imageSize by remember { mutableStateOf(IntSize.Zero) }
    var containerSize by remember { mutableStateOf(IntSize.Zero) }

    val isZoomedIn = scale !=zoomedOutScale

    Box(
        modifier = modifier
            .onSizeChanged { containerSize = it }
            .pointerInput(isZoomedIn) {
                detectTapGestures(
                    onDoubleTap = {
                        if (isZoomedIn) {
                            scale = zoomedOutScale
                            offsetX = 0f
                            offsetY = 0f
                        } else {
                            scale = zoomedInScale
                        }
                    }
                )
            }
            .pointerInput(isZoomedIn) {
                if (isZoomedIn) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        val (dx, dy) = dragAmount

                        val maxOffsetX = ((imageSize.width * scale) - containerSize.width) / 2
                        val maxOffsetY = ((imageSize.height * scale) - containerSize.height) / 2

                        offsetX = (offsetX + dx).coerceIn(-maxOffsetX, maxOffsetX)
                        offsetY = (offsetY + dy).coerceIn(-maxOffsetY, maxOffsetY)
                    }
                } else {
                    detectTapGestures(
                        onDoubleTap = {
                            scale = zoomedInScale
                        }
                    )
                }
            }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imagePath),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offsetX
                    translationY = offsetY
                }
                .align(Alignment.Center)
                .onSizeChanged { imageSize = it }
                .fillMaxSize()
        )
    }
}
