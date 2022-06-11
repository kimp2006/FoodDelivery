package com.example.fooddelivery.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fooddelivery.adapter.ProductAdapter
import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.model.ProductModel

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var adapter: ProductAdapter

    private val menuViewModel by viewModels<MenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }


    private fun initial() {
        with(binding) {
            adapter = ProductAdapter()
            tvMenu.adapter = adapter
            adapter.setList(myProduct())
        }
    }

    fun myProduct(): ArrayList<ProductModel>{
        val productList = ArrayList<ProductModel>()

        for(i in 0..100){
            val product1 = ProductModel("title $i", "description $i")
            productList.add(product1)
        }

        return productList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}