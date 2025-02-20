package com.udacity.shoestore.shoeList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel(){
    val shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val navigateToSelectedShoe: MutableLiveData<Unit?> = MutableLiveData()
    fun addList(name: String, price: String, image: String){
        val actualList = shoes.value ?: mutableListOf()
        actualList.add(Shoe(
            name = name,
            size = price,
            images = image
        ))
        shoes.value = actualList
        navigateToSelectedShoe.value = Unit
    }

    fun cleanNavigateObserver(){
        navigateToSelectedShoe.value = null
    }
}