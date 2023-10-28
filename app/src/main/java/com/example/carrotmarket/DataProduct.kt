package com.example.carrotmarket

import java.io.Serializable

data class DataProduct(
    val thumnail: Int,
    val title: String,
    val address: String,
    val price: String,
    val commentNum: Int,
    val likeNum: Int,
) : Serializable
