package com.example.carrotmarket

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivitySignupBinding
import com.example.carrotmarket.remote.AuthService
import com.example.carrotmarket.remote.SignUpView

class SignupActivity:AppCompatActivity(), SignUpView {
    lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            val id=binding.editId.text.toString()
            val pw=binding.editPw.text.toString()
            val name=binding.editNickname.text.toString()
            val authService=AuthService()//여기로 넘김
            authService.setSignUpView(this)//자신이 상속해서 자신 넣어주기
            authService.signup(id,pw,name)//메소드 호출 따라서 엑티비에서 requset로 넘김

        }
    }

    override fun SignuUpLoading() {
        //loadgin progress 보여주기
    }

    override fun SignuUpSuccess() {
        Toast.makeText(this,"회원가입에 성공했습니다. 해당 계정으로 로그인 해주세여.",Toast.LENGTH_SHORT).show()//흐름 꼭 이해하기 로직
        onBackPressed()
    }

    override fun SignuUpFailure(code: Int, msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

    }
}