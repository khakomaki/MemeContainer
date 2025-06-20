package com.khakomaki.memecontainer.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> Grid(
    items: List<T>,
    modifier: Modifier = Modifier,
    rowItemCount: Int = 2,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    itemContent: @Composable (T) -> Unit
    ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(rowItemCount),
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items) { item ->
            itemContent(item)
        }
    }
}
