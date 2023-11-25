package com.example.carrotmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ProductEntitytable")

data class ProductEntity (
    val thumbnail:Int,//따로 position해서 받을지? adapter에서 뺴고 따로 apdapter 하나 만들어서?
    val title:String,
    val location:String,
    val price:String,
    val comment_num:Int,//int로 어떻게 보낼지?
    val like_num:Int
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id : Int =0//요거 프라이머리 키로 자동 생성해준다는?
}