package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.udacity.shoestore.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private  val auth: FirebaseAuth by lazy { Firebase.auth }
    private val navController: NavController by lazy { findNavController() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSingUpFragment.setOnClickListener {
            validateData()

        }
    }

    private fun validateData(){
       val email = binding.editTextSingUpEmail.text.toString()
       val password = binding.editTextSingUpPassword.text.toString()

        if(!email.isEmpty()) {
            if (!password.isEmpty()) {

                createAccount(email, password)

            }else {
                binding.editTextSingUpPassword.error = "Please enter password"
            }

        }else{
            binding.editTextSingUpEmail.error = "Please enter email"
        }
    }

    private fun createAccount(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                val action = SignUpFragmentDirections.actionSignUpFragmentToWelcome()
                navController.navigate(action)

            }else{
                binding.editTextSingUpEmail.error = "Email already exists"
            }
        }

    }

}