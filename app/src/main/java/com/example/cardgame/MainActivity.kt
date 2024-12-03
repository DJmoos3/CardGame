package com.example.cardgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import com.example.cardgame.databinding.ActivityMainBinding
import java.math.RoundingMode

class MainActivity : BaseActivity<ActivityMainBinding>() {

    /*var idNr = 0
    var percentValHigh = 0.0
    var percentValLow = 0.0
    var inARow = 0
    var lastNr = 1
    var curNr = 0*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var darkMode = false


        /*initiator(binding.higherChance,binding.lowerChance,binding.loseText,binding.inARowText,
            binding.cardFront,binding.cardBack,binding.lowerBtn,binding.higherBtn,binding.replay)*/

        binding.dayNight.setOnClickListener {
            if(!darkMode) {
                binding.main.setBackgroundColor(resources.getColor(R.color.black))
                binding.frameLayout.setBackgroundColor(Color.parseColor("#8E8E8E"))
                binding.dayNight.text = "\uD83C\uDF11"
                darkMode = true
            }else{
                binding.main.setBackgroundColor(resources.getColor(R.color.white))
                binding.frameLayout.setBackgroundColor(Color.parseColor("#ececec"))
                binding.dayNight.text = "\u2600"
                darkMode = false
            }
        }

        binding.playButton.setOnClickListener {
            val intent = Intent(this,CardGame::class.java)
            intent.putExtra("boolean", darkMode)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)

}
