package com.example.carrotmarket
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ProductDAO {

    @Insert
    fun addProduct(myString: ProductEntity)

    @Update
    fun updateProduct(myString: ProductEntity)

    @Delete
    fun deleteProduct(myString: ProductEntity)


    @Query("SELECT * FROM ProductInfoTable")
    fun getAllProducts() : List<ProductEntity>

    @Query("SELECT * FROM ProductInfoTable WHERE id=:id")
    fun getProductById(id : Int) : ProductEntity

}




