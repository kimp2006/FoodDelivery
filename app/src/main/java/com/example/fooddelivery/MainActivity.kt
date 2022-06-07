package com.example.fooddelivery

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.adapter.ProductAdapter
import com.example.fooddelivery.databinding.ActivityMainBinding
import com.example.fooddelivery.model.ProductModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initial()


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_menu, R.id.navigation_profile, R.id.navigation_cart
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    private fun initial() {
        recyclerView = binding.tv_menu
        adapter = ProductAdapter()
        recyclerView.adapter = adapter
        adapter.setList(myProduct())
    }

    fun myProduct(): ArrayList<ProductModel>{
        val productList = ArrayList<ProductModel>()

        val product1 = ProductModel("yy", "tt")
        productList.add(product1)

        val product2 = ProductModel("yy", "tt")
        productList.add(product2)

        val product3 = ProductModel("yy", "tt")
        productList.add(product3)

        val product4 = ProductModel("yy", "tt")
        productList.add(product4)

        return productList
    }
}