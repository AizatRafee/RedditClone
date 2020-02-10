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

    suspend fun updateUpVote(id: Int) = db.getTopicDao().updateUpVote(id)

    suspend fun updateDownVote(id: Int) = db.getTopicDao().updateDownVote(id)

    fun getTopics(count: Int) = db.getTopicDao().getTopics(count)

    fun getTopic(id: Int) = db.getTopicDao().getTopic(id)
}