package com.fridayhouse.myschools.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "schoolsResponseItem"
)
data class SchoolsResponseItem(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val state_province: String,
    val web_pages: List<String>
)