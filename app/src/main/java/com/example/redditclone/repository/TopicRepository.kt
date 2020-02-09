package com.example.redditclone.repository

import com.example.redditclone.db.AppDatabase
import com.example.redditclone.db.entities.Topic

/**
 * Created by aizat on 9/2/2020
 */

class TopicRepository(
    private val db: AppDatabase
) {

    suspend fun saveTopic(topic: Topic) = db.getTopicDao().upsert(topic)

    fun getTopics(count: Int) = db.getTopicDao().getTopics(count)
}