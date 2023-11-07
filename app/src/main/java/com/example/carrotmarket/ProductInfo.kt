package com.example.carrotmarket
import java.io.Serializable

class ProductInfo (
    val thumbnail: Int,
    val title: String,
    val location: String,
    val price: String,
    val comment_num: String, //int로 어떻게 보낼지?
    val like_num: String
):Serializable