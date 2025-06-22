package com.khakomaki.memecontainer.ui.screens.meme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.NewLabel
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khakomaki.memecontainer.data.model.Meme
import com.khakomaki.memecontainer.ui.components.ZoomableMeme
import com.khakomaki.memecontainer.ui.memes.MemeViewModel
import com.khakomaki.memecontainer.ui.screens.meme.components.BottomActionBar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemeDetailScreen(
    viewModel: MemeViewModel = viewModel(),
    memeId: String,
    onBack: () -> Unit
) {
    var meme by remember { mutableStateOf<Meme?>(null) }

    DisposableEffect(memeId) {
        val disposable: Disposable = viewModel.getMeme(memeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> meme = result },
                { error -> /* TODO implement error handling */ }
            )

        onDispose { disposable.dispose() }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(meme?.title ?: "Untitled")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            if (meme != null) {
                BottomActionBar(
                    actions = listOf(
                        Icons.Default.NewLabel to "Add Tag",
                        Icons.Default.Folder to "Add to Folder"
                    ),
                    onActionClick = { action ->
                        when (action) {
                            "Add Tag" -> { /* TODO implement adding Tag */ }
                            "Add to Folder" -> { /* TODO implement adding to Folder */ }
                        }
                    }
                )
            }
        }
    ) { padding ->
        meme?.let {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ) {
                    ZoomableMeme(imagePath = it.filePath)
                }

                /*
                Spacer(modifier = Modifier.height(16.dp))
                Text(formatTimeStamp(it.timestamp))
                Spacer(modifier = Modifier.height(8.dp))
                Text("Tags: #funny #cats") // TODO get Tags from Meme
                 */
            }
        } ?: Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
