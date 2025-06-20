package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FoldersTab(onFolderClick: (String) -> Unit) {
    val folders = listOf("Funny", "Unfunny", "Cats", "Work", "Donald Duck") // TODO remove placeholders

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(folders) { folder ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onFolderClick(folder) }
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Icon(Icons.Default.ThumbUp, contentDescription = null) // TODO import extended icons
                    Spacer(Modifier.width(8.dp))
                    Text(folder, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}
