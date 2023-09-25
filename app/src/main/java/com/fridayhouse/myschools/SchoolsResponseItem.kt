package com.fridayhouse.myschools

data class SchoolsResponseItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val state_province: String,
    val web_pages: List<String>
)