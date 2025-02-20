package com.udacity.shoestore.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.R


class DetailFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.setCustomView(R.id.toolbar)
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navigateToSelectedShoe.observe(viewLifecycleOwner, { event ->
            if (event != null)
                findNavController().popBackStack()
        })
        binding.icBackArrow.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.buttonSave.setOnClickListener {
            addShoe()
        }


    }

    private fun addShoe() {
        val editShoeName = binding.editDetailShoeName.text.toString()
        val editShoeSize = binding.editShoePrice.text.toString()
        val editShoeImage = binding.editShoeImage.text.toString()

        viewModel.addList(editShoeName, editShoeSize, editShoeImage)
    }
}