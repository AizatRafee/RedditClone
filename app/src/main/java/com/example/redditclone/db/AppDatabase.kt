package com.example.redditclone.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.redditclone.db.entities.Topic

/**
 * Created by aizat on 9/2/2020
 */

@Database(
    entities = [Topic::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTopicDao(): TopicDao

    companion object {
        private val dbName = "RedditDatabase.db"

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                dbName
            ).build()
    }
}