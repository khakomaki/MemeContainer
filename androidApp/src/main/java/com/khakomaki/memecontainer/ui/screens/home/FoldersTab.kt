package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.khakomaki.memecontainer.ui.components.Grid
import com.khakomaki.memecontainer.ui.folders.FolderCard

@Composable
fun FoldersTab(onFolderClick: (String) -> Unit) {
    val folders = listOf("Funny", "Unfunny", "Cats", "Work", "Donald Duck") // TODO remove placeholders

    Grid(
        items = folders
    ) { folder ->
        FolderCard(name = folder, onClick = { onFolderClick(folder) })
    }
}
