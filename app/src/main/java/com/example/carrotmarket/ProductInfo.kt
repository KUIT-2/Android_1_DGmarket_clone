package com.example.carrotmarket

import java.io.Serializable

data class ProductInfo(
    val thumbnail:Int,
    val title:String,
    val location:String,
    val price:String,
    val comment_num:Int,//int로 어떻게 보낼지?
    val like_num:Int
):Serializable
//serializable하게해서 intent에서 넘기기
//필요한 정보 다 기입
