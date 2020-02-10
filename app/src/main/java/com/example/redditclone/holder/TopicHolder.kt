package com.example.redditclone.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.redditclone.R
import com.example.redditclone.databinding.ItemTopicBinding
import com.example.redditclone.db.entities.Topic
import com.example.redditclone.util.SingleLiveEvent

/**
 * Created by aizat
 */
class TopicHolder(private val itemTopicBinding: ItemTopicBinding) :
    RecyclerView.ViewHolder(itemTopicBinding.root) {

    companion object {
        fun create(parent: ViewGroup): TopicHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewDataBinding: ItemTopicBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_topic, parent, false
            )

            return TopicHolder(viewDataBinding)
        }
    }

    fun bindTo(
        model: Topic,
        upVoteEvent: SingleLiveEvent<Int>,
        downVoteEvent: SingleLiveEvent<Int>,
        clickEvent: SingleLiveEvent<Int>
    ) {
        itemTopicBinding.topic = model

        itemTopicBinding.ibUpvote.setOnClickListener {
            upVoteEvent.postValue(model.id)
        }

        itemTopicBinding.ibDownvote.setOnClickListener {
            downVoteEvent.postValue(model.id)
        }

        itemTopicBinding.root.setOnClickListener {
            clickEvent.postValue(model.id)
        }
    }

}