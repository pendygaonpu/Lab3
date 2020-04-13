package com.example.lab3.ListView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lab3.Car
import com.example.lab3.R
import kotlinx.android.synthetic.main.row_list_view.view.*

class ListAdapter(context: Context, private var data: MutableList<Car>) : BaseAdapter(){

    //LayoutInflater object that will be used to retrieve the UI object tree from the layout
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    // The method returns the root of a tree of UI objects that display a list item
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        // We transform the layout into a tree of objects
        val view: View = inflater.inflate(R.layout.row_list_view, parent, false)
        //We get from the activity widgets
        val model = view.modelCar
        val image = view.imageView
        val year = view.yearCar
        val price = view.priceCar

        //Fill in the data widgets
        model.text = data[position].model
        image.setImageResource(data[position].photo)
        price.text = data[position].price
        year.text = data[position].year.toString()

        return view
    }

    // Retrieve a data item associated with a specified position in the dataset
    override fun getItem(position: Int): Any? = data[position]
    // Retrieve the line ID associated with the specified item in the list
    override fun getItemId(position: Int): Long = position.toLong()
    // Retrieve the number of items in a dataset
    override fun getCount(): Int = data.size
}