package com.example.firebaseauthmvvm.ui.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseauthmvvm.data.repository.PostRepository

@Suppress("UNCHECKED_CAST")
class PostViewModelFactory(private val repository : PostRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(repository) as T
    }

}