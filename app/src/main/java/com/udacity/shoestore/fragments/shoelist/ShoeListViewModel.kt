package com.udacity.shoestore.fragments.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

open class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    init {
        _name.value = "name"
        _shoeList.value = ArrayList()
    }

    fun addNewShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }



}