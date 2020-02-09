package com.example.redditclone.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

/**
 * Created by aizat
 */
@Keep
@Parcelize
data class Topic(
    val id: Int,
    val title: String?,
    val content: String?,
    val vote: Int,
    val userVote: Boolean?
) : Parcelable