package com.example.utspppb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utspppb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate dipanggil")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnSubmit.setOnClickListener {
                val username = binding.editTextName.text.toString()

                if (username.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Enter Your Name First", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // Send data using Intent to LoginActivity
                    val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra("EXTRA_NAME", editTextName.text.toString())
                    }
                    startActivity(intent)
                }
            }
        }
//            btnSubmit.setOnClickListener {
//                val intentToSecondActivity =
//                    Intent(this@MainActivity, SecondActivity::class.java)
//
//                intentToSecondActivity.putExtra("EXTRA_NAME", editTextName.text.toString())
//                startActivity(intentToSecondActivity)
//            }

    }
}