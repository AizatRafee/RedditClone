package com.example.redditclone.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.redditclone.base.BaseAndroidViewModel
import com.example.redditclone.db.AppDatabase
import com.example.redditclone.db.entities.Topic
import com.example.redditclone.repository.TopicRepository
import com.example.redditclone.util.Coroutines

/**
 * Created by aizat
 */
class HomeViewModel(application: Application) : BaseAndroidViewModel(application) {

    private val db = AppDatabase(application)
    private val repository = TopicRepository(db)

    // this function will return list of top 20 topic
    fun getTopics(): LiveData<List<Topic>> {
        return repository.getTopics(20)
    }

    // update vote in db by add 1
    fun upVote(id: Int) {
        Coroutines.main {
            repository.updateUpVote(id)
        }
    }

    // update vote in db by minus 1
    fun downVote(id: Int) {
        Coroutines.main {
            repository.updateDownVote(id)
        }
    }
}