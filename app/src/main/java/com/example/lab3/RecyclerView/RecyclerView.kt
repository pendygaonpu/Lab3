package com.example.lab3.RecyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Car


class RecyclerView : AppCompatActivity() {

    private var cars: MutableList<Car> = ArrayList()//Creating an array to store data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        cars.add(Car("GT86",2012,"18000",R.drawable.gt,"В хорошем состоянии"))
        cars.add(Car("RX7",1978,"25000",R.drawable.rx,"В хорошем состоянии"))
        cars.add(Car("GT86",1982,"1200000",R.drawable.supra,"В хорошем состоянии"))
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this)//Create a LinearLayoutManager object
        val viewAdapter: RecyclerView.Adapter<*> = RecyclerAdapter(cars) //create an adapter to access the data array
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview) //We get access to recyclerview in our activity
        recyclerView.apply {
            setHasFixedSize(true)// The size of RecyclerView will not change
            layoutManager = viewManager // Change the layout manager
            adapter = viewAdapter //We change the adapter
        }
    }
}