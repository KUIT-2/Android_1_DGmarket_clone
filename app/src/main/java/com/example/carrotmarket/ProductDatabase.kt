package com.example.carrotmarket

import android.app.Activity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 4)
abstract class ProductDatabase : RoomDatabase() {
    // MyStringDAO를 가져오는 추상 함수임
    abstract fun getMyProductDAO(): ProductDAO

    // 싱글톤 패턴 사용
    companion object {
        var instance: ProductDatabase? = null

        fun getInstance(context: HomeFragment): ProductDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.requireContext(), ProductDatabase::class.java, "myproduct-database"
                ).fallbackToDestructiveMigration()
                    .build() // .allowMainThreadQueries()를 지움 => thread/coroutine이 필수로 사용되어야 한다는 뜻임
            }
            return instance!!
        }
    }
}