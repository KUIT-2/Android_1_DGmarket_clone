package com.example.carrotmarket.remote

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call//임포트 주의

interface  RetrofitInterface {//인터페이스 기반으로 작동
    @POST("users/signup")
    fun singup(
        @Body request:SignUpRequest
    ):Call<BaseResponse<SignUpResponse>>//이론때 핸던 것 중 call방식으로 받겠다

    @POST("/users/login")//login부분
    fun singin(//로그인 함수 만들고
        @Body request:SignInRequest//토큰을 받아야하나?
    ):Call<BaseResponse<SignInResponse>>//이론때 핸던 것 중 call방식으로 받겠다
}