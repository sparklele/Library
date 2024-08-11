package com.example.library

import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val books : List<Book>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val item: View):RecyclerView.ViewHolder(item){
        val img : ImageView = itemView.findViewById(R.id.imageIG)
        val title : TextView = itemView.findViewById(R.id.titleTV)
        val author : TextView = itemView.findViewById(R.id.authorTV)
        val rating : RatingBar = itemView.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(item)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val stars = holder.rating.progressDrawable as LayerDrawable
        val emptyStar = stars.getDrawable(0)
        emptyStar.setColorFilter(ContextCompat.getColor(holder.itemView.context, R.color.black), PorterDuff.Mode.SRC_ATOP)
        val book = books.get(position)
        holder.img.setImageResource(book.img)
        holder.title.text=book.title
        holder.author.text=book.author
        holder.rating.rating=book.rating
    }

}