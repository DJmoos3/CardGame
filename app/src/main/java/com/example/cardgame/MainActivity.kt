package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import com.example.cardgame.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var score = intent.getIntExtra("highscore", 0)

        var darkMode = intent.getBooleanExtra("boolean", false)
        checkIfDark(darkMode, binding.main, binding.frameLayout, binding.dayNight)

        binding.dayNight.setOnClickListener {
            if (!darkMode){
                darkMode = true
                checkIfDark(darkMode, binding.main, binding.frameLayout, binding.dayNight)
            }else{
                darkMode = false
                checkIfDark(darkMode, binding.main, binding.frameLayout, binding.dayNight)
            }
        }

        binding.playButton.setOnClickListener {
            val intent = Intent(this,CardGame::class.java)
            intent.putExtra("boolean", darkMode)
            intent.putExtra("highestscore", score)
            startActivity(intent)
        }
        binding.highestScore.setOnClickListener {
            binding.highScoreText.isInvisible = false
            binding.scoreText.isInvisible = false
            binding.scoreText.text = "$score"
            binding.backBtn.isEnabled = true
            binding.backBtn.isInvisible = false
            binding.highestScore.isEnabled = false
            binding.highestScore.isInvisible = true
            binding.playButton.isEnabled = false
            binding.playButton.isInvisible = true
        }
        binding.backBtn.setOnClickListener {
            binding.highScoreText.isInvisible = true
            binding.scoreText.isInvisible = true
            binding.backBtn.isEnabled = false
            binding.backBtn.isInvisible = true
            binding.highestScore.isEnabled = true
            binding.highestScore.isInvisible = false
            binding.playButton.isEnabled = true
            binding.playButton.isInvisible = false
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)

}
