package com.khakomaki.memecontainer.data.repository

import com.khakomaki.memecontainer.data.db.MemeDao
import com.khakomaki.memecontainer.data.model.Meme
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

class MemeRepository(
    private val memeDao: MemeDao
) {
    fun getAllMemes(): Observable<List<Meme>> =
        memeDao.getAllMemes()

    fun getMemeById(id: String): Maybe<Meme> =
        memeDao.getMemeById(id)

    fun insertMeme(meme: Meme): Completable =
        memeDao.insertMeme(meme)
}
