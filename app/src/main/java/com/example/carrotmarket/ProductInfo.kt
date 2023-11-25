package com.example.carrotmarket

import java.io.Serializable

data class ProductInfo(
    val thumbnail:Int,//따로 position해서 받을지? adapter에서 뺴고 따로 apdapter 하나 만들어서?
    val title:String,
    val location:String,
    val price:String,
    val comment_num:Int,//int로 어떻게 보낼지?
    val like_num:Int
):Serializable
//serializable하게해서 intent에서 넘기기

//따로 holder로 빼서 받아야 하느지?