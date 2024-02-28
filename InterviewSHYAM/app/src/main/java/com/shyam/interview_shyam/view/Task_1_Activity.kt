package com.shyam.interview_shyam.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shyam.interview_shyam.R
import com.shyam.interview_shyam.adapter.Task1Adapter
import com.shyam.interview_shyam.databinding.ActivityTask1Binding
import com.shyam.interview_shyam.viewmodel.MyViewModel

class Task_1_Activity : AppCompatActivity() {
    lateinit var viewModel: MyViewModel
    lateinit var binding: ActivityTask1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTask1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        binding.recyclerview.layoutManager = GridLayoutManager(this, 3)
        viewModel.data.observe(this) {
            binding.recyclerview.adapter = Task1Adapter(this, it)
        }
    }
}