package com.example.eubutton.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.eubutton.R
import com.example.eubutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModelMain: ViewModelMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModelMain = ViewModelProvider(this).get(ViewModelMain::class.java)
        setContentView(binding.root)

        binding.btnQuantidade.setOnClickListener {
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("quantidade", binding.edtQuantidade.text.toString())
            startActivity(intent)
        }
    }
}