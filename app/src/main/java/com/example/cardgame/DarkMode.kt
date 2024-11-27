package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cardgame.databinding.ActivityDarkModeBinding
import com.example.cardgame.databinding.ActivityMainBinding


class DarkMode : AppCompatActivity() {

    lateinit var binding: ActivityDarkModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDarkModeBinding.inflate(layoutInflater)

        binding.dayNightDark.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

        setContentView(R.layout.activity_dark_mode)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}