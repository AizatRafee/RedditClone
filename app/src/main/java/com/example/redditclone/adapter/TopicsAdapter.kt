package com.example.redditclone.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redditclone.holder.TopicHolder
import com.example.redditclone.model.Topic

/**
 * Created by aizat
 */
class TopicsAdapter(val topic: List<Topic>) : RecyclerView.Adapter<TopicHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {
        return TopicHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return topic.size
    }

    override fun onBindViewHolder(holder: TopicHolder, position: Int) {
        holder.bindTo(topic[position])
    }

}