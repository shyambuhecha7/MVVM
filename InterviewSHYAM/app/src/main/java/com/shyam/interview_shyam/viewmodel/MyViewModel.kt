package com.shyam.interview_shyam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shyam.interview_shyam.Model.Data
import com.shyam.interview_shyam.Model.Item
import com.shyam.interview_shyam.retrofit.ApiService
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    //for Task - 1
    private val _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>> = _data

    //for Task-2
    private val _firstItemList = MutableLiveData<List<Item>?>()
    val firstItemList: LiveData<List<Item>?> get() = _firstItemList

    private val _secondItemList = MutableLiveData<List<Item>?>()
    val secondItemList: LiveData<List<Item>?> get() = _secondItemList

    init {
        val items = mutableListOf<Item>()
        for (i in 'A'..'J') {
            items.add(Item(i.toString(), 0))
        }
        _firstItemList.value = items

        _secondItemList.value = emptyList()

        //for task - 1
        viewModelScope.launch {
            val serverData = ApiService.instance.getData()

            _data.value = serverData.data
        }
    }

    fun moveLeftToRight(items: List<Item>) {
        val firstList = _firstItemList.value?.toMutableList()
        firstList?.removeAll(items)
        _firstItemList.value = firstList

        val secondList = _secondItemList.value?.toMutableList()
        secondList?.addAll(items)
        _secondItemList.value = secondList
    }

    fun moveRightToLeft(items: List<Item>) {
        val secondList = _secondItemList.value?.toMutableList()
        secondList?.removeAll(items)
        _secondItemList.value = secondList

        val firstList = _firstItemList.value?.toMutableList()
        firstList?.addAll(items)
        _firstItemList.value = firstList
    }

    fun incrementQuantity(item: Item, position: Int) {
        val firstItems = _firstItemList.value.orEmpty().toMutableList()
        if(item in firstItems ) {
            val  index = firstItems.indexOf(item)
            firstItems[index].quantity++
            _firstItemList.value = firstItems
        }

        val secondItems = _secondItemList.value.orEmpty().toMutableList()
        if(item in secondItems ) {
            val  index = secondItems.indexOf(item)
            secondItems[index].quantity++
            _secondItemList.value = secondItems
        }
    }

    fun decrementQuantity(item: Item, position: Int) {
        val firstItems = _firstItemList.value.orEmpty().toMutableList()
        if(item in firstItems ) {
            val  index = firstItems.indexOf(item)
            firstItems[index].quantity--
            _firstItemList.value = firstItems
        }

        val secondItems = _secondItemList.value.orEmpty().toMutableList()
        if(item in secondItems ) {
            val  index = secondItems.indexOf(item)
            secondItems[index].quantity--
            _secondItemList.value = secondItems
        }
    }
}
