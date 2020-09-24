package com.example.firebaseauthmvvm.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseauthmvvm.data.model.PostDTO
import com.example.firebaseauthmvvm.data.repository.PostRepository
import com.example.firebaseauthmvvm.util.StatusListener

class PostViewModel (private val repository : PostRepository) : ViewModel() {

    var authListener : StatusListener? = null

    var postDTOs : ArrayList<PostDTO> = arrayListOf()
    var str : String = ""

    init {
        postDTOs.clear()
    }

    val user by lazy {
        repository.currentUser()
    }

    fun loadPost() : ArrayList<PostDTO> {
        repository.getPost().addSnapshotListener { value, error ->
            if(value == null)return@addSnapshotListener

            for(snapshot in value.documents){
                var item = snapshot.toObject(PostDTO::class.java)
                postDTOs.add(item!!)
                str += item.postId
                println("csh : " + item.postId)
            }
        }
        return postDTOs
    }

}