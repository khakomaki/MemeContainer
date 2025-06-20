package com.khakomaki.memecontainer.data.model

import androidx.room.Entity

@Entity(primaryKeys = ["memeId", "tagName"])
data class MemeTagCrossRef(
    val memeId: String,
    val tagName: String
)
