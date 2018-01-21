package com.moczul.diffutilsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private val repository = ActorRepository()
    private val actorAdapter = ActorAdapter(repository.actorsSortedByRating)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = actorAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_by_name -> {
                actorAdapter.swap(repository.actorsSortedByName)
                true
            }
            R.id.sort_by_rating -> {
                actorAdapter.swap(repository.actorsSortedByRating)
                true
            }
            R.id.sort_by_birth -> {
                actorAdapter.swap(repository.actorsSortedByYearOfBirth)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}