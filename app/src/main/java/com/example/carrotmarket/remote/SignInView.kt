package com.example.carrotmarket.remote

interface SignInView {
    fun SignInLoading()
    fun SignInSuccess()
    fun SignInFailure(code: Int, msg: String)
}