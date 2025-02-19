package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeList : Fragment() {

    private val viewModel: ShoeListViewModel by lazy {
        ViewModelProvider(this).get(ShoeListViewModel::class.java)
    }

    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoes.observe(viewLifecycleOwner) {

            bindingShoe1(it[0])
            bindingShoe2(it[1])
            bindingShoe3(it[2])
            bindingShoe4(it[3])
            bindingShoe5(it[4])
            bindingShoe6(it[5])
            bindingShoe7(it[6])
            bindingShoe8(it[7])
            bindingShoe9(it[8])
            bindingShoe10(it[9])

        }
        viewModel.addImage()

//        binding.fabFloatingButton.setOnClickListener {
//            findNavController().navigate(ShoeListDirections.actionShoeListToTitleFragment2())
//        }

        activity?.onBackPressedDispatcher?.addCallback(this) {}

    }

    private fun bindingShoe1(shoe: Shoe) {
        binding.iShoe1.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe2(shoe: Shoe) {
        binding.iShoe2.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe3(shoe: Shoe) {
        binding.iShoe3.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe4(shoe: Shoe) {
        binding.iShoe4.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe5(shoe: Shoe) {
        binding.iShoe5.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe6(shoe: Shoe) {
        binding.iShoe6.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe7(shoe: Shoe) {
        binding.iShoe7.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe8(shoe: Shoe) {
        binding.iShoe8.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe9(shoe: Shoe) {
        binding.iShoe9.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }

    private fun bindingShoe10(shoe: Shoe) {
        binding.iShoe10.apply {
            ivShoe.load(shoe.images.first())
            tvShoeName.text = shoe.name
            tvShoeValue.text = shoe.size
        }
    }
}