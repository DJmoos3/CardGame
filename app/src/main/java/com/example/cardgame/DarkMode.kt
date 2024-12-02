package com.example.cardgame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import com.example.cardgame.databinding.ActivityDarkModeBinding


class DarkMode : BaseActivity<ActivityDarkModeBinding>(){

    //lateinit var binding: ActivityDarkModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //binding = ActivityDarkModeBinding.inflate(layoutInflater)

        //setContentView(binding.root)

        binding.dayNight.setOnClickListener {
            finish()
        }
        initiator(binding.higherChance,binding.lowerChance,binding.loseText,binding.inARowText,
            binding.cardFront,binding.cardBack,binding.lowerBtn, binding.higherBtn,binding.replay)


        binding.replay.setOnClickListener {
            reset()
            binding.replay.isInvisible = true
            binding.replay.isEnabled = false
        }
        binding.higherBtn.setOnClickListener {
            onClick("high")
        }
        binding.lowerBtn.setOnClickListener {
            onClick("low")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun inflateBinding(): ActivityDarkModeBinding = ActivityDarkModeBinding.inflate(layoutInflater)
}