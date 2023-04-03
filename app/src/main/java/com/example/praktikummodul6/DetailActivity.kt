package com.example.praktikummodul6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.praktikummodul6.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var notes: Notes? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Notes App")
        notes = intent.getParcelableExtra(MainActivity.INTENT_ITEM)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        notes?.let {
            binding.tvTitleNote.text = notes!!.title
            binding.tvNoteNote.text= notes!!.note
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}