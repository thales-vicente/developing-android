package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.load
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeList : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.cleanNavigateObserver()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoes.observe(viewLifecycleOwner, Observer { list->
            val inflater = LayoutInflater.from(requireContext())
            list.forEach { shoe->
               val item = inflater.inflate(R.layout.item_shoe, null)
                item.rootView.apply {
                    item.findViewById<ImageView>(R.id.iv_shoe).apply {
                        load(shoe.images)
                    }
                    item.findViewById<TextView>(R.id.tv_shoeName).apply {
                        text = shoe.name
                    }
                    item.findViewById<TextView>(R.id.tv_shoeValue).apply {
                        text = shoe.name
                    }
                }
                binding.lnShoeList.addView(item)
            }
        })

        binding.fabAddShoe.setOnClickListener {
            val action = ShoeListDirections.actionShoeListToDetailFragment2()
            findNavController().navigate(action)
        }
        activity?.onBackPressedDispatcher?.addCallback(this) {}
    }
}