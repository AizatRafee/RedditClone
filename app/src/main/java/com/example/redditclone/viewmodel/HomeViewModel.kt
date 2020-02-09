package com.example.redditclone.viewmodel

import android.app.Application
import com.example.redditclone.base.BaseAndroidViewModel
import com.example.redditclone.model.Topic

/**
 * Created by aizat
 */
class HomeViewModel(application: Application) : BaseAndroidViewModel(application) {

    /**
     * return stub data
     */
    fun getTopics(): List<Topic> {

        val topics = ArrayList<Topic>()
        for (i in 0..20) {
            topics.add(
                Topic(
                    i,
                    "This is title for stub data",
                    "This is content fro stub data. Content cannot exceed 255 characters.\nsecond line for content",
                    i,
                    null
                )
            )
        }

        return topics
    }
}