package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {//기능들 적는 곳
@Insert

fun addProduct(product:ProductEntity)
    @Update
    fun UpdateProduct(product:ProductEntity)

    @Delete
    fun deleteProducts(product:ProductEntity)

    @Query("SELECT*FROM ProductEntitytable")
    fun getProducts():List<ProductEntity>
}