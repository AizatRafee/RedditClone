package com.example.redditclone.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.redditclone.R
import com.example.redditclone.databinding.ItemTopicBinding
import com.example.redditclone.model.Topic

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

    fun bindTo(model: Topic) {
        itemTopicBinding.topic = model
    }

}