package com.khakomaki.memecontainer.ui.memes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.khakomaki.memecontainer.data.db.MemeDatabaseProvider
import com.khakomaki.memecontainer.data.model.Meme
import com.khakomaki.memecontainer.data.repository.MemeRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.UUID

class MemeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MemeRepository

    private val _memes = BehaviorSubject.create<List<Meme>>()
    val memes: Observable<List<Meme>> = _memes.hide()

    init {
        val dao = MemeDatabaseProvider.getDatabase(application).memeDao()
        repository = MemeRepository(dao)

        loadMemes()
    }

    fun loadMemes() {
        repository.getAllMemes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { memes -> _memes.onNext(memes) }
    }

    fun addMeme(filePath: String, title: String?) {
        val meme = Meme(
            id = UUID.randomUUID().toString(),
            filePath = filePath,
            title = title
        )
        repository.insertMeme(meme)
            .subscribeOn(Schedulers.io())
            .subscribe {
                loadMemes()
            }
    }

    fun getMeme(id: String): Observable<Meme> {
        return repository.getMemeById(id).toObservable()
    }
}
