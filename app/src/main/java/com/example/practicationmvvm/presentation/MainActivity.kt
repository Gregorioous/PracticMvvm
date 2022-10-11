package com.example.practicationmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicationmvvm.R
import com.example.practicationmvvm.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    val categoriesViewModel: CategoriesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        categoriesViewModel.migration(this)


        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.bottomNav?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
                R.id.categoriesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Categories()).commit()

            }

            return@setOnItemSelectedListener true
        }


    }


}