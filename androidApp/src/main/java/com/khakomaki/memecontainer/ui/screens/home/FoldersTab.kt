package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import com.khakomaki.memecontainer.ui.components.Grid
import com.khakomaki.memecontainer.ui.folders.FolderCard

@Composable
fun FoldersTab(
    onFolderClick: (String) -> Unit,
    scrollState: LazyGridState
) {
    val folders = listOf("Funny", "Unfunny", "Cats", "Work", "Donald Duck") // TODO remove placeholders

    Grid(
        items = folders,
        scrollState = scrollState
    ) { folder ->
        FolderCard(name = folder, onClick = { onFolderClick(folder) })
    }
}
