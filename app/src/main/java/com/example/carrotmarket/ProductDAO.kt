package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDAO {
    @Insert
    fun insertMyProduct(myProduct: ProductEntity)

    @Update
    fun updateMyProduct(myProduct: ProductEntity)

    @Delete
    fun deleteMyProduct(myProduct: ProductEntity)

    @Query("SELECT * FROM ProductTable")
    fun getAllMyProduct(): List<ProductEntity>
}