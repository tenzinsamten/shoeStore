package com.udacity.shoestore.fragments.addshoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.fragments.shoelist.ShoeListViewModel
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAddShoeBinding>(inflater,R.layout.fragment_add_shoe,container,false)
        binding.addButton.setOnClickListener {
            val name = binding.shoeNameEditText.text.toString()
            val brand = binding.shoeBrandEditText.text.toString()
            val size = binding.shoeSizeEditText.text.toString().toDouble()
            val description = binding.shoeDescriptionEditText.text.toString()
            val currentShoe = Shoe(name = name,size = size,brand,description = description)
            shoeListViewModel.addNewShoe(currentShoe)
            findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())

        }
        return binding.root
    }
}