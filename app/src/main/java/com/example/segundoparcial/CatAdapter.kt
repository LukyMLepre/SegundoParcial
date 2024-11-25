package com.example.segundoparcial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CatAdapter(
    private val cats: List<Cat>,
    private val onItemClick: (Cat) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]
        holder.bind(cat)
        holder.itemView.setOnClickListener { onItemClick(cat) }
    }

    override fun getItemCount() = cats.size

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val catImageView: ImageView = itemView.findViewById(R.id.catImageView)

        fun bind(cat: Cat) {
            Picasso.get().load(cat.url).into(catImageView)
        }
    }
}

