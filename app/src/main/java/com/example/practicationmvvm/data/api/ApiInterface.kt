package com.example.practicationmvvm.data.api

import com.example.practicationmvvm.data.models.CategoriesApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("loadCategories.php")
    fun loadCategoriesApi(): Call<ArrayList<CategoriesApiModel>>
}