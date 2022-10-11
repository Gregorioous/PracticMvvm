package com.example.practicationmvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.practicationmvvm.data.models.CategoriesModel

interface CategoriesDataSource {

    fun insert(categoriesModel: CategoriesModel)

    fun loadCategories(): LiveData<List<CategoriesModel>>

    suspend fun clear()


}