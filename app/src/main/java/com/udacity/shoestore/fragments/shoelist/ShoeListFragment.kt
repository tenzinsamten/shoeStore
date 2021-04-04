package com.udacity.shoestore.fragments.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var inflater: LayoutInflater
    private var container: ViewGroup? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.shoeList = this
        this.inflater = inflater
        this.container = container

        shoeListViewModel.shoeList.observe(requireActivity(), { shoeList ->
            showShoesToLayout(shoeList)
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    fun addShoePage() {
        findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
    }


    private fun showShoesToLayout(shoeList: ArrayList<Shoe>) {
        if (shoeList.isEmpty()) {
            binding.emptyTextView.visibility = View.VISIBLE
        } else {
            binding.emptyTextView.visibility = View.GONE
            for (shoe in shoeList) {
                displayNewListToLayout(shoe)
            }
        }

    }

    private fun displayNewListToLayout(shoe: Shoe) {
        val shoeBinding = DataBindingUtil.inflate<ShoeItemLayoutBinding>(
            inflater,
            R.layout.shoe_item_layout,
            container,
            false
        )
        shoeBinding.shoe = shoe
        binding.shoeListLayout.addView(shoeBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> {
                findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}