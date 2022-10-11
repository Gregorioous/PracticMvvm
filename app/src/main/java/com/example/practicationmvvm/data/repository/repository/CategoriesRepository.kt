package com.example.practicationmvvm.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.practicationmvvm.data.models.CategoriesModel
import com.example.practicationmvvm.data.repository.dataSource.CategoriesApiDataSource
import com.example.practicationmvvm.data.repository.dataSource.CategoriesDataSource
import com.example.practicationmvvm.domain.repository.CategoriesCall

class CategoriesRepository (private val categoriesApiDataSource: CategoriesApiDataSource,
                            private val categoriesDataSource: CategoriesDataSource
): CategoriesCall {

    override  fun loadCategories(): LiveData<List<CategoriesModel>> {
        return categoriesDataSource.loadCategories()
    }
    override suspend fun startMigration(context: Context) {
        categoriesDataSource.clear()
        categoriesApiDataSource.startMigration(context)
    }

}