package com.example.carrotmarket.local

import android.util.Log
import com.example.carrotmarket.ApplicationClass
import com.example.carrotmarket.MyCarrotFragment


fun getJwt(): String? {//return 을 스트링으로
    //여기서는 토큰을 가져오게
    //일단 .saveJwt해서 안에 토큰이 있는지 하고 없으면 null반환 해주고 ,잇으면 ok해주자
    val tokenget=ApplicationClass.mSharedPreferencesManager.getString("Token",null)
    val result = tokenget?.let { tokenget } ?: null//맞으면 tokenget 없으면 null인데 login 다음이니까 맞을껄..?
    return result//nullable하게 바꿈
}

fun removeJwt(target:String){//지울거 target으로 받음
    val editor=ApplicationClass.mSharedPreferencesManager.edit()
    editor.remove("Token")
    editor.apply()
}
fun saveJwt(nickname:String,token:String){//토큰을 savedInstance에 넣기
    val editor=ApplicationClass.mSharedPreferencesManager.edit()

    editor.putString("Nickname",nickname)//TODO:리무브면 지우고 그렇게 로직구현
    editor.putString("Token",token)

    editor.apply()//이러면 shared에 들어감?

}







//TODO: 선택사항->RoomDB 복습 차원에서...상품 누르면 상세 페이지 가는 하트 기능 구현->누르면 찜이 되고, DB에 저장이 되는거 구현하기(로그인 된 상태에서만 찜하기)
//TODO:로그인 먼저 해주세요 라고 toast 만들기, 찜리스트 만들어서 넣기, nickname정보도 넣기
//TODO:닉네임별로 리스트 저장, 관심목록에서 찜 목록 보여주게 하기 ->ROOMDB써서 아