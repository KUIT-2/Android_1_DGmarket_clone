package com.example.carrotmarket.remote

interface SignUpView {
    fun SignuUpLoading()
    fun SignuUpSuccess()
    fun SignuUpFailure(code:Int,msg:String)
}