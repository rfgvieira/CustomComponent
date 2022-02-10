package com.example.eubutton.presentation.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.eubutton.R
import com.example.eubutton.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOtherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOtherBinding.inflate(layoutInflater)
        intent.getStringExtra("quantidade")?.let {
            binding.custom.quantity = it.toInt()
            binding.custom.greenColor = ContextCompat.getColor(this, R.color.green)
            binding.custom.whiteColor = ContextCompat.getColor(this, R.color.buraco)
            binding.custom.grayColor = ContextCompat.getColor(this, R.color.gray)
        }
        setContentView(binding.root)

        binding.btnProssegue.setOnClickListener {
            binding.custom.passed++
            binding.custom.invalidate()
        }

    }
}