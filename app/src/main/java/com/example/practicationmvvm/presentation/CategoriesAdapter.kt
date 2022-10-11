package com.example.practicationmvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicationmvvm.data.models.CategoriesModel
import com.example.practicationmvvm.databinding.CategoriesItemBinding
import com.squareup.picasso.Picasso

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoryHolder>() {

    private val categoryList = ArrayList<CategoriesModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {

        val binding : CategoriesItemBinding = CategoriesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    fun setList(products: List<CategoriesModel>) {
        categoryList.clear()
        categoryList.addAll(products)

    }


    class CategoryHolder(val binding: CategoriesItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            categoriesModel: CategoriesModel

        ) {

            val getImage = categoriesModel.image
            Picasso.get().load(getImage).into(binding.imageProduct)
            binding.idProduct.text = categoriesModel.id.toString()
            binding.nameProduct.text = categoriesModel.name


        }

    }

}

