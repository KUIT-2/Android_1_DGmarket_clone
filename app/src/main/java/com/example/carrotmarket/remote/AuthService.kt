package com.example.carrotmarket.remote

import android.util.Log
import retrofit2.Callback
import com.example.carrotmarket.ApplicationClass
import com.example.carrotmarket.local.saveJwt
//import com.example.carrotmarket.local.getJwt
//import com.example.carrotmarket.local.saveJwt
import retrofit2.Call
import retrofit2.Response

class AuthService {
    private val authService= ApplicationClass.retrofit.create(RetrofitInterface::class.java)//레트로피 메소드 만든 정보를 삽입 하는 것
    //왜 applicationclass에 하냐면 계속 요청이 올텐데, 매번 하면 부담이니, 그냥 전역변수로 초기화해서 살아있게 해서
    //계속 사용하게(매번 새로 생성 하고 빌드 아닌 한번 생성하고 계속 쓰기)
    private lateinit var signUpView:SignUpView//중복돼서 컴파일 돼지 않게 하기위해
    private lateinit var signInView:SignInView//로그인

    fun setSignUpView(signUpView: SignUpView){//아직 초기화가 안됐음 따라서 activity에서 해주기
        this.signUpView=signUpView//signupVIew 사용 하기 위해
    }
    fun setSignInView(signInView: SignInView){//아직 초기화가 안됐음 따라서 activity에서 해주기
        this.signInView=signInView//signupVIew 사용 하기 위해
    }
    fun signup(id:String,pw:String,name:String){
        signUpView.SignuUpLoading()//업로딩때 어떤 화면 보여줄지
        val request= SignUpRequest(id,pw,name)//요청부분
        authService.singup(request).enqueue(object :Callback<BaseResponse<SignUpResponse>>{//익명이니 함수 구현 해줘야 함+enqueue 로 자동 비동기
            override fun onResponse(//성공
                call: Call<BaseResponse<SignUpResponse>>,//call
                response: Response<BaseResponse<SignUpResponse>>//응답 받는
            ) {
            var resp=response.body()//body받기
                Log.d("Signup response",resp.toString())
                when(resp!!.code){//nullable 하고code부분 받아
                    201-> {
                        signUpView.SignuUpSuccess()
                        }

                    else->signUpView.SignuUpFailure(resp.code,resp.message)//실패에 이걸 넘겨줌
                }
            }
            override fun onFailure(call: Call<BaseResponse<SignUpResponse>>, t: Throwable) {//Throwable !
                Log.d("SignUp failed",t.toString())//실패했을때 어떤 이윤지
            }
        })//body 넣어야 하나 request,enqueue가 비동기로 자동으로 !
    }
    fun signin(id:String,pw:String){
        val request= SignInRequest(id,pw)//요청부분
        authService.singin(request).enqueue(object :Callback<BaseResponse<SignInResponse>>{//익명이니 함수 구현 해줘야 함+enqueue 로 자동 비동기
            override fun onResponse(
                call: Call<BaseResponse<SignInResponse>>,
                response: Response<BaseResponse<SignInResponse>>
            ) {
                var resp = response.body()//여기 token이랑 nickname두개 받는데 어케 처리>
                Log.d("Signin response", resp.toString())//로그에 찍기
                Log.d("check","돌아는 가니?")
                when (resp!!.code) {//nullable 하고code부분 받아
                    200 -> {//성공하면 토큰받게
                        val signInResponse: SignInResponse? = resp.result//여기서 토큰 닉네임 가져옴
                        signInResponse?.let {
                            signInView.SignInSuccess()//여기는 그냥 성공만
                            saveJwt(resp.result.nickname,resp.result.token)//nickname,token대입

                            Log.d("AuthService", "Nickname: ${resp.result.nickname}, Token: ${resp.result.token}")
                            //TODO:여기서 sharedrpeference에 넣고, loginActivity에서 가져와서 텍스트 전달?
                        }
                    }
                    else -> signInView.SignInFailure(resp.code, resp.message)//실패에 이걸 넘겨줌
                }
            }
            override fun onFailure(call: Call<BaseResponse<SignInResponse>>, t: Throwable) {
                Log.d("SignIn failed",t.toString())//실패했을때 어떤 이윤지 쓰로어블하게
            }
        })
    }
}