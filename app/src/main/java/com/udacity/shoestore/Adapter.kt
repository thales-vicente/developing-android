package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe

class Adapter(private val shoes: List<Shoe>, private val onItemClicked: (Shoe) -> Unit): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(val binding: ItemShoeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(shoe: Shoe, onItemClicked: (Shoe) -> Unit){
            binding.tvShoeName.text = shoe.name
            binding.tvShoeValue.text = shoe.size.toString()
            binding.ivShoe.load(shoe.images[0])
            binding.root.setOnClickListener {
                onItemClicked(shoe)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemShoeBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun getItemCount(): Int = shoes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shoes[position], onItemClicked)
    }

}