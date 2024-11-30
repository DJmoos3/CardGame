package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cardgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var idNr : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var curNr = 0
        var lastNr = 1

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.dayNight.setOnClickListener {
            val intent = Intent(this,DarkMode::class.java)
            startActivity(intent)
        }

        binding.higherBtn.setOnClickListener {
            if (idNr != 0) {
                binding.cardBack.setImageResource(idNr)
            }
            if(binding.loseText.text != ""){
                binding.loseText.text = ""
                binding.cardBack.setImageResource(R.drawable.gray_back)
                idNr = 0
            }
            if (lastNr != curNr){
                lastNr = 0
            }
            curNr = imageSelect(binding.cardFront)
            if (curNr < lastNr){
                binding.loseText.text = "You lost"
            }else {
                lastNr = curNr
            }
        }
        binding.lowerBtn.setOnClickListener {
            if (idNr != 0) {
                binding.cardBack.setImageResource(idNr)
            }
            if(binding.loseText.text != ""){
                binding.loseText.text = ""
                binding.cardBack.setImageResource(R.drawable.gray_back)
                idNr = 0
            }
            if (lastNr != curNr){
                lastNr = 15
            }
            curNr = imageSelect(binding.cardFront)
            if (curNr > lastNr){
                binding.loseText.text = "You lost"
            }else {
                lastNr = curNr
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun imageSelect(imageView: ImageView):Int {
        var random : Int
        var id : String
        random = kotlin.random.Random.nextInt(1,4)
        if(random == 1) {
            id = "c"
        } else if (random == 2){
            id = "d"
        }else if(random == 3){
            id = "h"
        }else{
            id = "s"
        }
        random = kotlin.random.Random.nextInt(2,14)
        id += random
        idNr = resources.getIdentifier(id, "drawable", packageName)
        imageView.setImageResource(idNr)
        return random
    }
}
