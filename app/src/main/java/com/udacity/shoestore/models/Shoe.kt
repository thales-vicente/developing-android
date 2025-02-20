package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Shoe(
    val name: String,
    val size: String,
    val images: String
) : Parcelable


