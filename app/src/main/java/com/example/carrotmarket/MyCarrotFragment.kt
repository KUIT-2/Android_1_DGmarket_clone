package com.example.carrotmarket

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentMyBinding
import com.example.carrotmarket.local.removeJwt

class MyCarrotFragment : Fragment() {
    lateinit var binding: FragmentMyBinding
    override fun onResume() {//여기에 로그인&로그아웃을 구현 했어야 했다 생명주기 공부 더하기
        super.onResume()
        if (isLoggedIn()) {//로그인 된 경우
            binding.tvNickname.text = ApplicationClass.mSharedPreferencesManager.getString(
                "Nickname",
                "유저 정보가 없습니다."
            )//왜 h로 나옴?
            binding.tvLogin.text = "로그아웃"
            binding.loginBtn.setOnClickListener {//TODO: 여기인데 로그인을 로그아웃으로 바뀌게 하기 Loginactivity에서 받아서
                binding.tvNickname.text = "로그인을 해주세요"
                binding.tvLogin.text = "로그인"
                removeJwt("Token")//토큰삭제하고 다시 화면 바뀌어야함
                Toast.makeText(requireContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT)//온 뷰 크링이트?
                    .show()//프래그먼트니 requirecontext
            }
        } else {
            binding.loginBtn.setOnClickListener {//로그인 누르면 로그인 액티비티로
                val loginIntent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(loginIntent)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(layoutInflater)
        Log.d("test_createview","Createview")//스타트찍기
        if (isLoggedIn()) {
            // 로그인 상태인 경우
            binding.tvNickname.text = ApplicationClass.mSharedPreferencesManager.getString(
                "Nickname",
                "유저 정보가 없습니다."
            )
            binding.tvLogin.text = "로그아웃"
        }

        binding.loginBtn.setOnClickListener {
            if (isLoggedIn()) {
                // 로그인 상태인 경우 로그아웃 처리
                binding.tvNickname.text = "로그인을 해주세요"
                binding.tvLogin.text = "로그인"
                removeJwt("Token") // 토큰 삭제하고 다시 화면이 바뀌어야 함
                Toast.makeText(requireContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 로그아웃 상태인 경우 로그인 액티비티로 이동
                val loginIntent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(loginIntent)
            }
        }

        /*if (isLoggedIn()) {//로그인 된 경우
            binding.tvNickname.text = ApplicationClass.mSharedPreferencesManager.getString(
                "Nickname",
                "유저 정보가 없습니다."
            )//정보넣기
            binding.tvLogin.text = "로그아웃"
        }
        if(isLoggedIn()){
            binding.loginBtn.setOnClickListener {//TODO: 여기인데 로그인을 로그아웃으로 바뀌게 하기 Loginactivity에서 받아서
                removeJwt("Token")//토큰삭제하고 다시 화면 바뀌어야함
                Toast.makeText(requireContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT)//온 뷰 크링이트?
                    .show()//프래그먼트니 requirecontext
            }
        }else {
            binding.loginBtn.setOnClickListener {//로그인 누르면 로그인 액티비티로
                val loginIntent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(loginIntent)
            }
        }*/
        return binding.root
    }
    private fun isLoggedIn(): Boolean {//로그인 여부?
        val token = ApplicationClass.mSharedPreferencesManager.getString("Token", null)
        return !token.isNullOrBlank()
    }
}