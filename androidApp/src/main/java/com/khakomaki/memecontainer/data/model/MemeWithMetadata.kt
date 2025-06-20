package com.khakomaki.memecontainer.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MemeWithMetadata(
    @Embedded
    val meme: Meme,

    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(MemeTagCrossRef::class)
    )
    val tags: List<Tag> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(MemeFolderCrossRef::class)
    )
    val folders: List<Folder> = emptyList()
)
