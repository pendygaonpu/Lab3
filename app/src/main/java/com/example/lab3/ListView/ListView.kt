package com.example.lab3.ListView

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.example.lab3.Car
import com.example.lab3.CarView
import com.example.lab3.R


class ListView : AppCompatActivity() {

    private var cars: MutableList<Car> = ArrayList()//Створення масиву для збереженя даних

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //Fill the array with data
        val list: ListView = findViewById(R.id.listView)

        cars.add(Car("GT86",2012,"18000",R.drawable.gt,"В хорошем состоянии"))
        cars.add(Car("RX7",1978,"25000",R.drawable.rx,"В хорошем состоянии"))
        cars.add(Car("GT86",1982,"1200000",R.drawable.supra,"В хорошем состоянии"))

        val myAdapter = ListAdapter(this, cars)//Creating an adapter object
        list.adapter = myAdapter //Transfer the adapter to the list widget

        //Code to process when clicking on any one item in the list
        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, CarView::class.java)//create the intention
            intent.putExtra("position", position)//We convey the position of the list item clicked
            intent.putParcelableArrayListExtra("list", ArrayList(cars))//pass on all the data
            this.startActivity(intent)//opening a new activity
        }
    }
}