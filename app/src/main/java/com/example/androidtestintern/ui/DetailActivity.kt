package com.example.androidtestintern.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidtestintern.R
import com.example.androidtestintern.databinding.ActivityDetailBinding
import com.example.androidtestintern.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            textCelcius.editText?.setText(intent.getDoubleExtra("tempC",0.0).toString())
            textFahrenheit.editText?.setText(intent.getDoubleExtra("tempF",0.0).toString())
        }
    }
}