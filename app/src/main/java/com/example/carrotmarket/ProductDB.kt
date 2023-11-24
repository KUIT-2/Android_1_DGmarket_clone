package com.example.carrotmarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[ProductEntity::class],version=2)


abstract class ProductDB: RoomDatabase() {//구현 위해 ROomDb받아오기

    abstract fun getMyProductDao():ProductDao//나중에 Dao에서 선언한 기능들 쓰기 위해 선언

    companion object{//스태틱 이라고 생각(항상 있는 것)
    var instance : ProductDB? = null//instance를 사용하는 것
        fun getInstance(context: Context):ProductDB{//여길 homeFragment 를 가져오던가 아니면 getinstance에서 다르게 하던가
            if(instance==null){//null인 경우!
                instance= Room.databaseBuilder(//db 만들어 주는 함수
                    context,//context가져옴 이렇게만 쓰려면 다른곳에서 requireContext해서 하나는 다르게
                    ProductDB::class.java,//class가져와야된다
                    "mystring-database"//db의 이름
                ).fallbackToDestructiveMigration()//버전 바꾸면 이전꺼 삭제
                    .build()
            }
            return instance!!//그냥 기존거 받아옴
        }
    }
}