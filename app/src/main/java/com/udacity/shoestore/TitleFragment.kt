package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.udacity.shoestore.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    private  val auth: FirebaseAuth by lazy { Firebase.auth }
    private val navController: NavController by lazy { findNavController() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         binding = FragmentTitleBinding.inflate(inflater ,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignIn.setOnClickListener {
            validateData()

        }
        binding.buttonSignUp.setOnClickListener {
            val action = TitleFragmentDirections.actionTitleFragment2ToSignUpFragment()
            navController.navigate(action)

        }
        activity?.onBackPressedDispatcher?.addCallback(this) {
            activity?.finish()
        }
    }
    private fun validateData(){
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextPassword.text.toString()

        if(!email.isEmpty()) {
            if (!password.isEmpty()) {

                loginAccount(email, password)

            }else {
                binding.editTextPassword.error = "Please enter password"
            }

        }else{
            binding.editTextTextEmailAddress.error = "Please enter email"
        }
    }

    private fun loginAccount(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                val action = TitleFragmentDirections.actionTitleFragment2ToWelcome()
                navController.navigate(action)

            }else{
                binding.editTextTextEmailAddress.error = "Email or password incorrect"
                binding.editTextPassword.error = "Email or password incorrect"
            }
        }

    }
}