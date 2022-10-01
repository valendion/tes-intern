package com.example.androidtestintern.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.androidtestintern.R

import com.example.androidtestintern.databinding.ActivityMainBinding
import com.example.androidtestintern.utils.Status

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val items = listOf("Parepare", "Makassar")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        (binding.autoComplete as? AutoCompleteTextView)?.setAdapter(adapter)

        val weatherFactory = WeatherFactory.getInstance()
        val viewModel: WeatherViewModel by viewModels { weatherFactory }


        binding.btnSubmit.setOnClickListener {
            val key = binding.inputApi.editText?.text.toString()
            val city = binding.choseCity.editText?.text.toString().lowercase()

            viewModel.getWeather(key,city).observe(this){
                if (it != null){
                    when(it){
                        is Status.Loading ->{
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is Status.Success ->{
                            binding.progressBar.visibility = View.GONE
                            val data= it.data.current
                            startActivity(Intent(this,DetailActivity::class.java)
                                .putExtra("tempC", data.tempC)
                                .putExtra("tempF", data.tempF))
                        }
                        is Status.Error ->{
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan : ${it.error}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}
