package com.khakomaki.memecontainer.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.khakomaki.memecontainer.data.model.Meme
import com.khakomaki.memecontainer.data.model.MemeWithMetadata
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

@Dao
interface MemeDao {
    @Query("SELECT * FROM memes ORDER BY timestamp DESC")
    fun getAllMemes(): Observable<List<Meme>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeme(meme: Meme): Completable

    @Delete
    fun deleteMeme(meme: Meme): Completable

    @Query("SELECT * FROM memes WHERE id = :id")
    fun getMemeById(id: String): Maybe<Meme>

    @Transaction
    @Query("SELECT * FROM memes ORDER BY timestamp DESC")
    fun getAllMemesWithMetadata(): Observable<List<MemeWithMetadata>>

    @Transaction
    @Query("""
        SELECT * FROM memes
        WHERE id IN (
            SELECT memeId FROM MemeFolderCrossRef
            WHERE folderId = :folderId
        )
        ORDER BY timestamp DESC
    """)
    fun getMemesByFolder(folderId: String): Observable<List<MemeWithMetadata>>
}
