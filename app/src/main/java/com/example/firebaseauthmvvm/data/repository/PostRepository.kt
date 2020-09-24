package com.example.firebaseauthmvvm.data.repository

import com.example.firebaseauthmvvm.data.firebase.FirebaseSource
import com.google.firebase.firestore.CollectionReference

class PostRepository (private val firebase : FirebaseSource) {

    fun currentUser() = firebase.currentUser()

    fun getPost() = firebase.getPost()
}