package com.example.lab3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.actvity_one_item.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CarView : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_one_item)

        //accept data that was sent from another activity
        val position: Int = getIntent().getIntExtra("position", 0)
        val list = getIntent().getParcelableArrayListExtra<Car>("list")

        //Adding this data to new actvity_one_item activity
        modelTextView.text = list[position].model
        yearTextView.text = "Год: " + list[position].year
        priceTextView.text = "Цена: "  + list[position].price
        imageView.setImageResource(list[position].photo)
        stateTextView.text = "Состояние: "  + list[position].state
    }
}