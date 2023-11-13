package com.example.carrotmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ProductTable")
data class ProductEntity(
    val thumnail: Int,
    val title: String,
    val address: String,
    val price: String,
    val commentNum: Int,
    val likeNum: Int,
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
