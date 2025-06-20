package com.khakomaki.memecontainer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "folders")
data class Folder(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String
)
