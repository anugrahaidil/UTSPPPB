package com.example.utspppb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utspppb.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    private lateinit var binding: ActivitySecondBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val data = result.data
                val address = data?.getStringExtra("EXTRA_ADDRESS")
                binding.textViewName.setText(address)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate dipanggil")

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("EXTRA_NAME")
        with(binding) {
            textViewName.setText(name)
            btnKeluar.setOnClickListener {
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                Toast.makeText(
                    this@SecondActivity,
                    "You have successfully log out",
                    Toast.LENGTH_SHORT
                ).show()
                launcher.launch(intent)
            }
        }
    }
}