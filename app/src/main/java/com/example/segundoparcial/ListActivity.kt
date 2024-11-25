package com.example.segundoparcial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Usar datos harcodeados
        catAdapter = CatAdapter(catsData) { selectedCat ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("catId", selectedCat.id)
            startActivity(intent)
        }

        recyclerView.adapter = catAdapter
    }
}

