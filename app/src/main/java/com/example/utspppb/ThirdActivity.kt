package com.example.utspppb

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.utspppb.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val TAG = "ProfileActivity"
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate dipanggil")

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}