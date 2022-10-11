package com.example.practicationmvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.practicationmvvm.data.models.CategoriesModel
import com.example.practicationmvvm.domain.repository.CategoriesCall

class CategoriesUseCase (private val categoriesCall: CategoriesCall) {


     fun loadCategories(): LiveData<List<CategoriesModel>> {

        return categoriesCall.loadCategories()

    }

    suspend fun startMigration (context: Context) {

        categoriesCall.startMigration(context)

    }





}