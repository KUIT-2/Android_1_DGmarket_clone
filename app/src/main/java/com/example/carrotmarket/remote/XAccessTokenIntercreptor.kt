package com.example.carrotmarket.remote

import com.example.carrotmarket.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.local.getJwt
//import com.example.carrotmarket.local.getJwt
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class XAccessTokenIntercreptor : Interceptor {//여기서 토큰 자동으로 인터셉트 해옴
    //상속받음
    override fun intercept(chain: Interceptor.Chain): Response {//요청 가기 전마다 들림
        val builder: Request.Builder = chain.request().newBuilder()//요청의 복사본 가져와서 build한 것
//TODO:이 부분은 header에 삽입하는 부분!(LOGIN은 response받아서 shared로 하는 것)
      val jwtToken: String? = getJwt()//이거 뭐하지??->토큰 가져오게
        // get으로 토큰 가져와서 헤더에 추가.
        //만일 헤더에 존재하면 login ok, 아니면 x하기
        //TODO:여기 let으로 어떻게 하기??
       jwtToken?.let {//null아니면 실행
            builder.addHeader(X_ACCESS_TOKEN, "Bearer $jwtToken")//헤더로 가는지? Bearer $값 이거 형식 지키기
        }//앞에가 키 뒤에가 토큰
        //따라서 앞에꺼 키를 받아서 토큰과 비교해서 맞으면 실행인데, 서버에서 인증하여 사용가능
        return chain.proceed(builder.build())//이건 무슨 말인지?
        //응답은 어디서 받는지?
    }
}