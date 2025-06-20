package com.khakomaki.memecontainer.data.model

import androidx.room.Entity

@Entity(primaryKeys = ["memeId", "folderId"])
data class MemeFolderCrossRef(
    val memeId: String,
    val folderId: String
)
