package com.udacity.shoestore.fragments.addshoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAddShoeBinding>(
            inflater,
            R.layout.fragment_add_shoe,
            container,
            false
        )
        val currentShoe = Shoe()
        binding.shoeViewModel = shoeListViewModel

        binding.addButton.setOnClickListener {
            shoeListViewModel.addNewShoe()
            findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }
        binding.cancelButton.setOnClickListener {
            shoeListViewModel.clearShoeContent()
            findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())

        }
        return binding.root
    }
}