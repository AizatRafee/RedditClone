package com.example.redditclone.viewmodel

import android.app.Application
import android.view.View
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
    private val topicId: Int? get() = arguments.getInt(TOPIC_ID)
    var topicLive: LiveData<Topic>? = null

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

    // this function will map topic base on id
    fun getTopicFromRepo() {
        topicId?.let { id -> topicLive = repository.getTopic(id) }
    }

    fun clickUpVote(view: View) {
        topicId?.let { id -> upVote(id) }
    }

    fun clickDownVote(view: View) {
        topicId?.let { id -> downVote(id) }
    }

    companion object {
        val TOPIC_ID = "topic_id"
    }
}