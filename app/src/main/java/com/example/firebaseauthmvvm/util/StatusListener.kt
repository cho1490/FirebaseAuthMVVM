package com.example.firebaseauthmvvm.util

interface StatusListener {

    fun onStarted()

    fun onSuccess()

    fun onFailure(message : String)

}