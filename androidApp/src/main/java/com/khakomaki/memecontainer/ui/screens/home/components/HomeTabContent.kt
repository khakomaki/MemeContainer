package com.khakomaki.memecontainer.ui.screens.home.components

import androidx.compose.runtime.Composable
import com.khakomaki.memecontainer.ui.screens.home.AllMemesTab
import com.khakomaki.memecontainer.ui.screens.home.FoldersTab
import com.khakomaki.memecontainer.ui.screens.home.Tab

@Composable
fun HomeTabContent(
    selectedTab: Tab,
    onMemeClick: (String) -> Unit,
    onFolderClick: (String) -> Unit
) {
    when (selectedTab) {
        Tab.Folders -> FoldersTab(onFolderClick = onFolderClick)
        Tab.AllMemes -> AllMemesTab(onMemeClick = onMemeClick)
    }
}
