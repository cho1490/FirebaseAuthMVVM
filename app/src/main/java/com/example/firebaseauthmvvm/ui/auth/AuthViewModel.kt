package com.example.firebaseauthmvvm.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.firebaseauthmvvm.data.repository.UserRepository
import com.example.firebaseauthmvvm.util.StatusListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthViewModel (private val repository : UserRepository) : ViewModel() {

    var email : String? = null
    var password : String? = null

    var authListener : StatusListener? = null

    private val disposables = CompositeDisposable()

    val user by lazy {
        repository.currentUser()
    }

    fun login() {
        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("이메일 또는 패스워드를 넣어주세요")
            return
        }

        authListener?.onStarted()

        val disposable = repository.login(email!!, password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
            }, {
               authListener?.onFailure(it.message!!)
            })

        disposables.add(disposable)
    }

    fun signUp(){
        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("이메일 또는 패스워드를 넣어주세요")
            return
        }

        authListener?.onStarted()

        val disposable = repository.register(email!!, password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
            }, {
                authListener?.onFailure(it.message!!)
            })

        disposables.add(disposable)
    }

    fun goToSignUp(view : View) {
        Intent(view.context, SignUpActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun goToLogin(view : View) {
        Intent(view.context, LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

}