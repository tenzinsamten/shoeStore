package com.udacity.shoestore.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Shoe : BaseObservable() {
    var name: String = ""
    var size: Int = 0
    var company: String = ""
    var description: String = ""

    @JvmName("getName1")
    @Bindable
    fun getName(): String {
        return this.name
    }

    @JvmName("setName1")
    fun setName(name: String) {
        if (this.name != name) {
            this.name = name
            notifyPropertyChanged(BR.shoe)
        }
    }

    @JvmName("getSize1")
    @Bindable
    fun getSize(): Int {
        return size
    }

    @JvmName("getSize1")
    fun setSize(size: Int) {
        if (this.size != size) {
            this.size = size
            notifyPropertyChanged(BR.shoe)
        }
    }

    @JvmName("getCompany1")
    @Bindable
    fun getCompany(): String {
        return this.company
    }

    @JvmName("getCompany1")
    fun setCompany(company: String) {
        if (this.company != company) {
            this.company = company
            notifyPropertyChanged(BR.shoe)
        }
    }

    @JvmName("getDescription1")
    @Bindable
    fun getDescription(): String {
        return this.description

    }

    @JvmName("setDescription1")
    fun setDescription(description: String) {
        if (this.description != description) {
            this.description = description
            notifyPropertyChanged(BR.shoe)
        }

    }
}