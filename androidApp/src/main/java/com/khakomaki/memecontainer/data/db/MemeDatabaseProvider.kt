package com.khakomaki.memecontainer.data.db

import android.content.Context
import androidx.room.Room

object MemeDatabaseProvider {
    @Volatile
    private var INSTANCE: MemeDatabase? = null

    fun getDatabase(context: Context): MemeDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context = context.applicationContext,
                klass = MemeDatabase::class.java,
                name = "meme_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
