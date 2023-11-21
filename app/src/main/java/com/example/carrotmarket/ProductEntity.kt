package com.example.carrotmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "ProductInfoTable")
data class ProductEntity(
    var thumbnail : Int,
    var title: String,
    val location: String,
    val price: String,
    val comment_num: String, //int로 어떻게 보낼지?
    val like_num: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}

//{
  //  @PrimaryKey(autoGenerate = true) //데이터베이스라면 항상 가져야 하는 키
    //var id: Int = 0
//}