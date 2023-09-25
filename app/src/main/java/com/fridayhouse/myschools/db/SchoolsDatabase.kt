package com.fridayhouse.myschools.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fridayhouse.myschools.models.SchoolsResponseItem


@Database(
    entities = [SchoolsResponseItem::class],
    version = 1
)
abstract class SchoolsDatabase : RoomDatabase() {

    abstract fun getSchoolDao(): SchoolsDao

    companion object {
        @Volatile
        private var instance: SchoolsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SchoolsDatabase::class.java,
                "schools_db.db"
            ).build()

    }
}