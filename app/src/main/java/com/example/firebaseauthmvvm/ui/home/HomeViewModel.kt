package com.example.firebaseauthmvvm.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.firebaseauthmvvm.data.repository.UserRepository
import com.example.firebaseauthmvvm.util.startLoginActivity
import com.example.firebaseauthmvvm.util.startPostActivity

class HomeViewModel (private val repository : UserRepository) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun startPostActivity(view : View){
        view.context.startPostActivity()
    }

    fun logout(view : View) {
        repository.logout()
        view.context.startLoginActivity()
    }

}