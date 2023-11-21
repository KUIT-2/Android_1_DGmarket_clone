package com.example.carrotmarket

import androidx.room.Database
import androidx.room.Room
import android.content.Context
import androidx.room.RoomDatabase


//데이터베이스임을 명시, version은 데이터베이스의 버전

@Database(entities = [ProductEntity::class], version = 2)
//추상클래스 RoomDatabase를 상속
abstract class ProductDatabase : RoomDatabase() {
    //getProductDAO로 ProductDAO를 가져온다
    abstract fun getProductDAO(): ProductDAO

    companion object {
        var instance: ProductDatabase? = null


        fun getInstance(context : Context): ProductDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "product-database"
                ).fallbackToDestructiveMigration()
                    .build()
//                    .allowMainThreadQueries().build()
            }
            return instance!!
        }

    }




}



