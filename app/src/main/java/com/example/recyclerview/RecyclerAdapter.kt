package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

   class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

       private var title = arrayOf("Kirana", "Vishnu", "Sairam", "Shashi", "Lokesh", "Pushkal", "Vinay", "Karthik");
       private var detail = arrayOf("Dev - TCPL", "Dev - LBIT", "Dev - LBIT", "Dev - TCPL","Dev - TCPL","Dev - TCPL","Dev - TCPL","Dev - TCPL");
       private val images = intArrayOf(R.drawable.image,R.drawable.image,R.drawable.image,
           R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image)

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
           return ViewHolder(v);
       }

       override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
           holder.itemTitle.text =  title[position];
           holder.itemDetail.text =  detail[position];
           holder.itemImage.setImageResource(images[position])
       }

       override fun getItemCount(): Int {
          return title.size;
       }

       inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
           var itemImage: ImageView
           var itemTitle: TextView
           var itemDetail: TextView

           init {
               itemImage = itemView.findViewById(R.id.image)
               itemTitle = itemView.findViewById(R.id.item_title)
               itemDetail = itemView.findViewById(R.id.sub_title)
               itemView.setOnClickListener{
                   val position: Int = adapterPosition
                   Toast.makeText(itemView.context, "You clicked on ${title[position]}", Toast.LENGTH_SHORT).show();
               }
           }
       }
   }