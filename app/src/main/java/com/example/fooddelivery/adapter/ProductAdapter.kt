package com.example.fooddelivery.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.R
import com.example.fooddelivery.model.ProductModel


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = emptyList<ProductModel>()

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        private val tvDescription = view.findViewById<TextView>(R.id.tv_description)

        fun bind(position: Int) {
            tvTitle.text = productList[position].title
            tvDescription.text = productList[position].description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_layout, parent, false)
        return ProductViewHolder(view)
    }   // tut neobhodimo ukazat na item_product_layout. Gde imenno to chto nam budet pokazivat.


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(position)


    }     // teper holder znaet kakoj view brat


    override fun getItemCount(): Int {
        return productList.size  // vozvrachaem ves LIST, libo mojno ukazat luboje chislo iz LISTa
    }

    @SuppressLint("NotifyDataSetChanged")    // anotazija k notifyDataSetChanged()
    fun setList(list: List<ProductModel>)   // funkzija setList, s peremennoj ona budet v sebja trebovat peremennuju List<ProductModel>
    {
        productList =
            list                  // mi vizivaem etu funkziju i kidaem tuda list. Etot list mi naznachem, ukazivaem chto, etot list zapihnem
        // teper sudaje

        notifyDataSetChanged()               // posle togo kak mi zapolnili list, udalili ili vnesli izminenija, nam nujno adapter izvestit,
        // tak kak on sam ob etom ne znaet. Poetomu neobhodimo ukazivat v ruchnuju.


    }


}


//    adapter - eto klas kotorij slujit dlja togo
//    chtobi objedenit nash spisok s nachej modelju, ili je
//    otobrozit dannije kotorije k nam prihodjat (ot kuda ne vajno)
//    v etom spiske.
//    Adapter mi unasledujem ot RecyclerView


