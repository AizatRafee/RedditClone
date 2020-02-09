package com.example.redditclone.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redditclone.db.entities.Topic
import com.example.redditclone.holder.TopicHolder
import com.example.redditclone.util.SingleLiveEvent

/**
 * Created by aizat
 */
class TopicsAdapter(var topic: List<Topic>?) : RecyclerView.Adapter<TopicHolder>() {

    val upVoteEvent = SingleLiveEvent<Int>()
    val downVoteEvent = SingleLiveEvent<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {
        return TopicHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return topic?.size ?: 0
    }

    override fun onBindViewHolder(holder: TopicHolder, position: Int) {
        topic?.get(position)?.let {
            holder.bindTo(it, upVoteEvent, downVoteEvent)
        }
    }
}