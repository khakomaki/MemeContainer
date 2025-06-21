package com.khakomaki.memecontainer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "memes")
data class Meme(
    @PrimaryKey()
    val id: String = UUID.randomUUID().toString(),
    val filePath: String,
    val title: String?,
    val timestamp: Long = System.currentTimeMillis(),
    val type: MemeType = MemeType.IMAGE
)
