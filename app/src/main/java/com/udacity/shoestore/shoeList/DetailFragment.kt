package com.udacity.shoestore.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import coil.load
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.R


class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
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
        binding.apply {
            ivShoeDetail.load(args.shoe.images.first())
            tvDetailShoeName.text = args.shoe.name
            tvShoePrice.text = args.shoe.size.toString()
        }
        binding.icBackArrow.setOnClickListener {
            activity?.onBackPressed()
        }

    }

}