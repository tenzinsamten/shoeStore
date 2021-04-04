package com.udacity.shoestore.fragments.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

open class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    init {
        _shoeList.value = ArrayList()
        _shoe.value = Shoe()
    }

    fun addNewShoe() {
        _shoeList.value?.add(shoe.value!!)
        _shoe.value = Shoe()
    }

    fun clearShoeContent() {
        _shoe.value = Shoe()
    }


}