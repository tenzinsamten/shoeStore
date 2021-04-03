package com.udacity.shoestore.fragments.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.login = this
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

        return binding.root
    }

    fun onButtonClicked() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        if (email.isNotBlank() && password.isNotBlank()) {
            val savedEmail = readFromSharePreference()
            if (savedEmail == email) {
                // don't show welcome page
                findNavController().navigate(R.id.action_loginFragment_to_shoeListFragment)
            } else {
                // save and show welcome page
                addSharePreference(email)
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }

        } else {
            Toast.makeText(context, "Email or password is empty", Toast.LENGTH_SHORT).show()
        }

    }

    fun addSharePreference(email: String) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(getString(R.string.email_key), email)
            apply()
        }
    }

    private fun readFromSharePreference(): String {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref?.getString(getString(R.string.email_key), "") ?: ""
    }


}