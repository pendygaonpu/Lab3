package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.lab3.ListView.ListView
import com.example.lab3.RecyclerView.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when ((view as Button).id) {
            //Opens activity for ListView
            R.id.buttonListView -> startActivity(Intent(this, ListView::class.java))
            //Opens activity for RecyclerView
            R.id.buttonRecyclerView -> startActivity(Intent(this, RecyclerView::class.java))
        }
    }
}
