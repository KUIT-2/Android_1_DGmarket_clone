package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {//인터페이스니 구현은 못 하는 부분임
@Insert

fun addProduct(product:ProductEntity)
    @Update
    fun UpdateProduct(product:ProductEntity)

    @Delete
    fun deleteProducts(product:ProductEntity)

    @Query("SELECT*FROM ProductEntitytable")//이걸 getProducts
    fun getProducts():List<ProductEntity>
}