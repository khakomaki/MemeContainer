package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khakomaki.memecontainer.data.model.Meme
import com.khakomaki.memecontainer.ui.components.Grid
import com.khakomaki.memecontainer.ui.memes.MemeCard
import com.khakomaki.memecontainer.ui.memes.MemeViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

@Composable
fun AllMemesTab(
    viewModel: MemeViewModel = viewModel(),
    onMemeClick: (String) -> Unit
) {
    val memesState = remember { mutableStateOf<List<Meme>>(emptyList()) }

    DisposableEffect(Unit) {
        val disposable = viewModel.memes
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { memes ->
                memesState.value = memes
            }

        onDispose { disposable.dispose() }
    }

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
            items = memesState.value,
            modifier = Modifier.weight(1f)
        ) { meme ->
            MemeCard(
                name = meme.title ?: "Untitled",
                onClick = { onMemeClick(meme.id) }
            )
        }
    }
}
