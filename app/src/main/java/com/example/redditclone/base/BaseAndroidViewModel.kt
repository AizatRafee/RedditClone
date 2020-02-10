package com.example.redditclone.base

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel

/**
 * Created by aizat
 */
abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {
    protected val arguments: Bundle = Bundle()

    fun addBundle(bundle: Bundle?) {
        arguments.putAll(bundle)
    }
}