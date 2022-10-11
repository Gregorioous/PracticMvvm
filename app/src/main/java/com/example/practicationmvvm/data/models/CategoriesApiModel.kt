package com.example.practicationmvvm.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoriesApiModel (

    @SerializedName("id") @Expose
    var id: Int? = null,
    @SerializedName("name") @Expose
    var name: String? = null,
    @SerializedName("image") @Expose
    var image: String? = null

)