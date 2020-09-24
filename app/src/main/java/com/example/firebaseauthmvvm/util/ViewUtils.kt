package com.example.firebaseauthmvvm.util

import android.content.Context
import android.content.Intent
import com.example.firebaseauthmvvm.ui.auth.LoginActivity
import com.example.firebaseauthmvvm.ui.home.HomeActivity
import com.example.firebaseauthmvvm.ui.post.PostActivity

fun Context.startHomeActivity() =
    Intent(this, HomeActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

fun Context.startLoginActivity() =
    Intent(this, LoginActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

fun Context.startPostActivity() =
    Intent(this, PostActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

