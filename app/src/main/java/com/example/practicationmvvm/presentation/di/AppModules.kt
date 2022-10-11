package com.example.practicationmvvm.presentation.di

import androidx.room.Room
import com.example.practicationmvvm.data.localDB.Database
import com.example.practicationmvvm.data.repository.dataSource.CategoriesApiDataSource
import com.example.practicationmvvm.data.repository.dataSource.CategoriesDataSource
import com.example.practicationmvvm.data.repository.dataSourceIMPL.CategoriesApiDataSourceIMPL
import com.example.practicationmvvm.data.repository.dataSourceIMPL.CategoriesDataSourceIMPL
import com.example.practicationmvvm.data.repository.repository.CategoriesRepository
import com.example.practicationmvvm.domain.repository.CategoriesCall
import com.example.practicationmvvm.domain.useCase.CategoriesUseCase
import com.example.practicationmvvm.presentation.CategoriesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleCategories = module{

    single {
        Room.databaseBuilder(androidContext(), Database::class.java,
            "localDB").build()
    }

    single { get<Database>().categoriesDao }


    single<CategoriesDataSource> {
        CategoriesDataSourceIMPL(
            get()
        )
    }

    single<CategoriesApiDataSource> {
        CategoriesApiDataSourceIMPL(
            get()
        )
    }

    single<CategoriesCall> { CategoriesRepository(get(),get()) }

    single { CategoriesUseCase(get()) }

    viewModel { CategoriesViewModel(get()) }

}