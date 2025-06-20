package com.khakomaki.memecontainer.ui.navigation

object Routes {
    const val HOME = "home"
    const val ADD = "add"
    const val MEME_ID = "memeId"
    const val DETAIL = "detail/{$MEME_ID}"

    fun detail(memeId: String): String = "detail/$memeId"
}
