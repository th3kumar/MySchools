package com.fridayhouse.myschools.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fridayhouse.myschools.models.SchoolsResponseItem

@Dao
abstract class SchoolsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsert(schoolsResponseItem: SchoolsResponseItem): Long

    @Query("SELECT * FROM schoolsResponseItem")
    abstract fun getAllSchools(): LiveData<List<SchoolsResponseItem>>

    @Delete
    abstract suspend fun deleteSchool(schoolsResponseItem: SchoolsResponseItem)
}