package com.shyam.interview_shyam.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shyam.interview_shyam.Model.Item
import com.shyam.interview_shyam.adapter.MyAdapter
import com.shyam.interview_shyam.databinding.ActivityMainBinding
import com.shyam.interview_shyam.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter1: MyAdapter
    private lateinit var adapter2: MyAdapter
    private lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView1.layoutManager = LinearLayoutManager(this)
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        viewModel.firstItemList.observe(this) {
            adapter1 = MyAdapter(viewModel, it)
            binding.recyclerView1.adapter = adapter1
        }

        viewModel.secondItemList.observe(this){
            adapter2 = MyAdapter(viewModel, it)
            binding.recyclerView2.adapter = adapter2
        }


        binding.buttonMoveRightItems.setOnClickListener {
            val selectedItems: List<Item> = adapter1.getSelectedItems()

            viewModel.moveLeftToRight(selectedItems)
        }

        binding.buttonMoveLeftItems.setOnClickListener {
            val selectedItems: List<Item> = adapter2.getSelectedItems()

            viewModel.moveRightToLeft(selectedItems)
        }
    }
}