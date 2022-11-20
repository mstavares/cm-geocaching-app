package com.github.mstavares.geocaching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mstavares.geocaching.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.fabSave.setOnClickListener {
            if(!hasErrorsOnTheForm()) {
                items.add(
                    Item(
                    binding.edtDescription.text.toString(),
                    Difficulty.EASY, Location(0, 0.0, 0.0)
                ))
                binding.tvEntries.text = items.toString()
            }
        }
    }

    private fun hasErrorsOnTheForm(): Boolean {
        if(binding.edtDescription.text.isNullOrEmpty()) {
            binding.tilDescription.error = getString(R.string.error_blank_field)
            return true
        }
        return false
    }

}