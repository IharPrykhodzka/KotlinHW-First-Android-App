package com.example.myfirstapplicationkotlin

data class Post(
    val id: Int,
    val icon: Int,
    val dateForPost: Long,
    val author: String,
    val content: String,
    var likedByMe: Boolean = false,
    var registeredLikes: Int = 0,
    var commentedByMe: Boolean = false,
    var registeredComments: Int = 0,
    var sharedByMe: Boolean = false,
    var registeredShares: Int = 0) {}