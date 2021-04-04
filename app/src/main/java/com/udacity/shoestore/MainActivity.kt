package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.fragments.shoelist.ShoeListViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        binding.toolbar.title = resources.getString(R.string.app_name)
        setSupportActionBar(binding.toolbar)


    }
}
