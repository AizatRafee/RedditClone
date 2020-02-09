package com.example.redditclone.viewmodel

import android.app.Application
import com.example.redditclone.base.BaseAndroidViewModel
import com.example.redditclone.db.AppDatabase
import com.example.redditclone.db.entities.Topic
import com.example.redditclone.repository.TopicRepository
import com.example.redditclone.util.Coroutines

/**
 * Created by aizat on 10/2/2020
 */

class PostViewModel(application: Application) : BaseAndroidViewModel(application) {

    var title: String? = null
    var content: String? = null
    private val db = AppDatabase(application)
    private val repository = TopicRepository(db)

    fun postTopic() {

        val topic = Topic(
            title,
            content,
            0,
            null
        )

        Coroutines.main {
            repository.saveTopic(topic)
        }
    }
}