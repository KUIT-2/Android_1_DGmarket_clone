package com.example.carrotmarket.remote

import com.google.gson.annotations.SerializedName

data class SignUpRequest(//요청때 보낼 data 즉 request 바디부분
    @SerializedName("userId")val userId:String,
    @SerializedName("password")val password:String,
    @SerializedName("nickname")val nickname:String,

    //대소문자 주의
    //SerializedName이란:HTTP 통신 요청 들어갈때 저 문자열 안에 key값으로 매핑 들어감
)
data class SignUpResponse(//받는 data,ID만 있으면 중복인지 아닌지 등,다 알 수 있어서
    @SerializedName("userId")val userId:String
)

data class SignInRequest(//로그인에 보낼거
    @SerializedName("userId")val userId:String,
    @SerializedName("password")val password:String,
    //아이디 비번만 받게
    //SerializedName이란:HTTP 통신 요청 들어갈때 저 문자열 안에 key값으로 매핑 들어감
)
data class SignInResponse(//닉네임과 토큰 얘네 Shared에 저장되게 하기 putString으로
    @SerializedName("nickname")val nickname:String,
    @SerializedName("token")val token:String,
)

data class GetUserDataResponse(//닉네임과 토큰 얘네 Shared에 저장되게 하기 putString으로
    @SerializedName("Id")val ID:String,//대문자 유의
    @SerializedName("nickname")val nickname:String,

)