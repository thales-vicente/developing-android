package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [Instructions.newInstance] factory method to
 * create an instance of this fragment.
 */
class Instructions : Fragment() {
private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionsBinding.inflate(inflater ,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btLetsGo.setOnClickListener {
            val action = InstructionsDirections.actionInstructionsToShoeList()
            view.findNavController().navigate(action)
        }
    }
}