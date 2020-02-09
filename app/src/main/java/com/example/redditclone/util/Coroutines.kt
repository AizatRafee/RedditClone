package com.example.redditclone.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by aizat on 9/2/2020
 */

object Coroutines {

    // coroutine funtion that return Job
    // this coroutine scope run in main thread
    fun main(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}