package com.example.redditclone.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.redditclone.base.BaseAndroidViewModel
import com.example.redditclone.db.AppDatabase
import com.example.redditclone.db.entities.Topic
import com.example.redditclone.repository.TopicRepository

/**
 * Created by aizat
 */
class HomeViewModel(application: Application) : BaseAndroidViewModel(application) {

    private val db = AppDatabase(application)
    private val repository = TopicRepository(db)

    fun getTopics(): LiveData<List<Topic>> {
        return repository.getTopics(20)
    }
}