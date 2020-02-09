package com.example.redditclone.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.redditclone.db.entities.Topic

/**
 * Created by aizat on 9/2/2020
 */

@Dao
interface TopicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(topic: Topic): Long

    @Query("SELECT * FROM topic ORDER BY vote DESC LIMIT :count")
    fun getTopics(count: Int): LiveData<List<Topic>>
}