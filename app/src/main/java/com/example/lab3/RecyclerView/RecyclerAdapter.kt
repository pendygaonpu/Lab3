package com.example.lab3.RecyclerView

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Car
import com.example.lab3.CarView
import com.example.lab3.R
import kotlinx.android.synthetic.main.row_card_view.view.*

class RecyclerAdapter(private var list: MutableList<Car>) : RecyclerView.Adapter<RecyclerAdapter.CarViewHolder>() {

    //create ViewHolder
    override fun onCreateViewHolder(vG: ViewGroup, i: Int): CarViewHolder {
        val v: View = LayoutInflater.from(vG.context) // Specify and populate the layout for each RecycleView element
            .inflate(R.layout.row_card_view, vG, false)
        return CarViewHolder(v) //Pass the layout to the ViewHolder constructor
    }

    //Retrieve the number of entries
    override fun getItemCount() = list.size

    // We set the value of the text boxes and the image resource
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.model.text = list[position].model
        holder.price.text = list[position].price
        holder.year.text = list[position].year.toString()
        holder.image.setImageResource(list[position].photo)

        //Handler for clicking on any item in RecyclerView
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.constrain.context, CarView::class.java) //create the intention
            intent.putExtra("position", position)//convey the position of the list item clicked
            intent.putParcelableArrayListExtra("list", ArrayList(list))//pass on all the data
            holder.constrain.context.startActivity(intent)//opening a new activity
        }
    }

    //ViewHolder class for data
    class CarViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.imageView
        var model: TextView = itemView.model
        var year: TextView = itemView.year
        var price: TextView = itemView.price
        var constrain: ConstraintLayout = itemView.constrain
    }

}