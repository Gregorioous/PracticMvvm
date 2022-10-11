package com.example.practicationmvvm.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practicationmvvm.data.models.CategoriesModel

@Database(entities = [CategoriesModel::class],version = 1)
    abstract class Database: RoomDatabase() {

    abstract val categoriesDao : CategoriesDao
}