package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khakomaki.memecontainer.ui.memes.AddMemeFAB
import com.khakomaki.memecontainer.ui.screens.home.components.HomeTabBar
import com.khakomaki.memecontainer.ui.screens.home.components.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onMemeClick: (String) -> Unit,
    onFolderClick: (String) -> Unit = {},
    onAddMemeClick: () -> Unit
) {
    val pagerState = rememberPagerState(initialPage = Tab.Folders.ordinal, pageCount = { Tab.entries.size })

    val folderScrollState = rememberLazyGridState()
    val memesScrollState = rememberLazyGridState()

    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = { AddMemeFAB(onAddMemeClick) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            HomeTabBar(pagerState = pagerState)

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                when (Tab.entries[page]) {
                    Tab.Folders -> FoldersTab(onFolderClick = onFolderClick, scrollState = folderScrollState)
                    Tab.AllMemes -> AllMemesTab(onMemeClick = onMemeClick, scrollState = memesScrollState)
                }
            }
        }
    }
}
