package com.example.redditclone.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by aizat on 10/2/2020
 */

// if more than 1000, display format like 12.1K
@BindingAdapter("voteCount")
fun setVoteCount(textView: TextView, count: Int) {
    textView.text = if (count >= 1000 || count <= -1000) {
        "${String.format("%.1f", count / 1000f)}K"
    } else {
        count.toString()
    }
}