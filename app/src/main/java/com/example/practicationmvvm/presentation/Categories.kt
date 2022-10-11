package com.example.practicationmvvm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicationmvvm.R
import com.example.practicationmvvm.databinding.CategoriesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class Categories : Fragment() {
    private var binding: CategoriesBinding? = null
    private var productAdapter: CategoriesAdapter? = null
    val productsViewModel: CategoriesViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoriesBinding.inflate(inflater, container, false)

        initRecyclerProducts()

        loadProducts()

        return binding?.root
    }

    private fun initRecyclerProducts(){
        binding?.recyclerProducts?.layoutManager = LinearLayoutManager(context)
        productAdapter = CategoriesAdapter()
        binding?.recyclerProducts?.adapter = productAdapter

    }

    private fun loadProducts(){
        productsViewModel.loadCategories.observe(viewLifecycleOwner, Observer {
            productAdapter?.setList(it)
            productAdapter?.notifyDataSetChanged()
        })
    }


}