package com.example.firebaseauthmvvm.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseauthmvvm.R
import com.example.firebaseauthmvvm.databinding.ActivityPostBinding
import com.example.firebaseauthmvvm.util.StatusListener
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class PostActivity : AppCompatActivity(), StatusListener, KodeinAware {

    override val kodein by kodein()
    private val factory : PostViewModelFactory by instance()

    private lateinit var viewModel : PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val binding: ActivityPostBinding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        viewModel = ViewModelProvider(this, factory).get(PostViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.loadPost()
        binding.invalidateAll()
        for(a in viewModel.postDTOs)
            println("csh : " + a.postId)
    }

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String) {
        TODO("Not yet implemented")
    }
}