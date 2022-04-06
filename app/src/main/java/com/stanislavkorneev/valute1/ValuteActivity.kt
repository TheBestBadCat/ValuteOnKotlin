package com.stanislavkorneev.valute1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView


class ValuteActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var valuteViewModel : ValuteViewModel
    var adapter = ValuteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.valuteRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        valuteViewModel = ViewModelProvider(this).get(ValuteViewModel::class.java)

        if (!valuteViewModel.isCalling) {
            valuteViewModel.getContent()
        }
        valuteViewModel.valuteList.observe(this, Observer {
            it?.let {
                adapter.valutes = it
                recyclerView.adapter = adapter
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        valuteViewModel.getContent()
        return super.onOptionsItemSelected(item)
    }

}
