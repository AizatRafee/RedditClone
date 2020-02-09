package com.example.redditclone.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by aizat
 */

@Entity
data class Topic(
    val title: String?,
    val content: String?,
    val vote: Int,
    val userVote: Boolean?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}