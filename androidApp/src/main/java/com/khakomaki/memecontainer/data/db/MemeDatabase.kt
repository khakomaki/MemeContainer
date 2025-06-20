package com.khakomaki.memecontainer.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khakomaki.memecontainer.data.model.Folder
import com.khakomaki.memecontainer.data.model.Meme
import com.khakomaki.memecontainer.data.model.MemeFolderCrossRef
import com.khakomaki.memecontainer.data.model.MemeTagCrossRef
import com.khakomaki.memecontainer.data.model.Tag

@Database(
    entities = [
        Meme::class,
        Tag::class,
        Folder::class,
        MemeTagCrossRef::class,
        MemeFolderCrossRef::class
    ],
    version = 1
)
abstract class MemeDatabase : RoomDatabase() {
    abstract fun memeDao(): MemeDao
}
