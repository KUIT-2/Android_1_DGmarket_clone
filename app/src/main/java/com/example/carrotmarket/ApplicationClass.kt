package com.example.carrotmarket

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.carrotmarket.remote.XAccessTokenIntercreptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass: Application() {//앱 살 아 있는 동안 계속 살아있는 클래스(관리를 위해 만들어보자)

    companion object{//공통 변수를 가지고 있는 객체 ->싱글톤, 클래스에 포함된 오브젝트
        const val X_ACCESS_TOKEN:String="Authorization"//토큰생성
        //이 response를 언제 보내?? login하고 save한 것을 가져오는 방향으로 잡자

        const val DEV_URL:String="http://13.125.254.172:23899"//두개 정도 해서 개발때랑 배포 URL구분(더 잘 되는 것으로 하기)
        const val PROD_URL:String="http://kuit_prod_url"

        const val BASE_URL:String= DEV_URL//이걸로 개바 진행
        lateinit var retrofit:Retrofit//빌더를 만드는 중,나중에 초기화
        lateinit var mSharedPreferencesManager: SharedPreferences//SharedPreferences받음
    }
    val client:OkHttpClient=OkHttpClient.Builder()//통신관여 객체, 헤더 넣을때 클라이언트로 넣음
        .readTimeout(30000,TimeUnit.MILLISECONDS)//시간제한
        .connectTimeout(30000,TimeUnit.MILLISECONDS)
        // .addInterceptor(logingInterceptor)
        .addNetworkInterceptor(XAccessTokenIntercreptor())//요청 넣기전에 가로채서 JWT 자동 헤더 전송
        .build()
    override fun onCreate() {//제일 먼저 시작
        super.onCreate()//레트로핏 만듬
        retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)//URL삽입
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())//Gson으로 컨버터 하게하는
            .build()//빌드하기
        mSharedPreferencesManager=applicationContext.getSharedPreferences("My App spf", Context.MODE_PRIVATE)//이건 shared에서 값 가져오는거
    }
}