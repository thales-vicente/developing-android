package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.Adapter
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import androidx.activity.addCallback
import androidx.lifecycle.LifecycleOwner

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
        initRecyclerView()
        viewModel.shoes.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = Adapter(it, onItemClicked = { shoe ->
                Log.i("ShoeList", "Shoe: $shoe")
                findNavController().navigate(
                    ShoeListDirections.actionShoeListToDetailFragment2(shoe)
                )
                viewModel.displayShoeDetailsComplete()

            })
        }
        viewModel.addImage()

        binding.fabFloatingButton.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListToTitleFragment2())
        }

        activity?.onBackPressedDispatcher?.addCallback(this) {}

    }

    private fun initRecyclerView() {
    }
}