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
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentMyBinding
import com.example.carrotmarket.local.removeJwt

class MyCarrotFragment : Fragment() {
    lateinit var binding: FragmentMyBinding
/*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginBtn.setOnClickListener {//눌리면
            if (isLoggedIn()) {//TODO:지피티가 써줬는데, 왜 IF문 두번인지..?
                if (isLoggedIn()) {
                    binding.tvNickname.text =
                        ApplicationClass.mSharedPreferencesManager.getString("Nickname", "유저 정보가 없습니다.")
                    binding.tvLogin.text = "로그아웃"

                } else {
                    binding.tvNickname.text = "유저 정보가 없습니다."
                    binding.tvLogin.text = "로그인"
                }
            } else {//로그인 X인 경우
                val loginIntent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(loginIntent)
            }
        }
    }
*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(layoutInflater)
     //로그인 안 된 경우
    if (isLoggedIn()) {//로그인 된 경우
        binding.tvNickname.text = ApplicationClass.mSharedPreferencesManager.getString(
            "Nickname",
            "유저 정보가 없습니다."
        )//왜 h로 나옴?
        binding.tvLogin.text = "로그아웃"
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
    }
        return binding.root
    }

    private fun isLoggedIn(): Boolean {//로그인 여부?
        val token = ApplicationClass.mSharedPreferencesManager.getString("Token", null)
        return !token.isNullOrBlank()
    }


}