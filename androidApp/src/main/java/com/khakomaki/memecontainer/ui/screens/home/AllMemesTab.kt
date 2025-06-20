package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khakomaki.memecontainer.ui.components.Grid
import com.khakomaki.memecontainer.ui.memes.MemeCard

@Composable
fun AllMemesTab(onMemeClick: (String) -> Unit) {
    val memes = List(20) { "Meme $it" } // TODO change placeholder

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Grid(
            items = memes,
            modifier = Modifier.weight(1f)
        ) { meme ->
            MemeCard(
                name = meme,
                onClick = { onMemeClick(meme) }
            )
        }
    }
}
