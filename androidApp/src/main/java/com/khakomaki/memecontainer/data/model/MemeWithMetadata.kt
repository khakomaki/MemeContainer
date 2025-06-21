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
        associateBy = Junction(
            value = MemeTagCrossRef::class,
            parentColumn = "memeId",
            entityColumn = "tagName"
        )
    )
    val tags: List<Tag> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = MemeFolderCrossRef::class,
            parentColumn = "memeId",
            entityColumn = "folderId"
        )
    )
    val folders: List<Folder> = emptyList()
)
