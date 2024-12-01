package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cardgame.databinding.ActivityMainBinding
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var idNr = 0
    var percentValHigh = 0.0
    var percentValLow = 0.0
    var inARow = 0
    var lastNr = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var curNr = 0

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
                reset()
            }
            if (lastNr != curNr){
                lastNr = 0
            }
            curNr = imageSelect(binding.cardFront)
            if (curNr < lastNr){
                gameLost()
            }else {
                roundProgression(curNr)
            }
        }
        binding.lowerBtn.setOnClickListener {
            if (idNr != 0) {
                binding.cardBack.setImageResource(idNr)
            }
            if(binding.loseText.text != ""){
                reset()
            }
            if (lastNr != curNr){
                lastNr = 15
            }
            curNr = imageSelect(binding.cardFront)
            if (curNr > lastNr){
                gameLost()
            }else {
                roundProgression(curNr)
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
        random = kotlin.random.Random.nextInt(2,15)
        id += random
        idNr = resources.getIdentifier(id, "drawable", packageName)
        imageView.setImageResource(idNr)
        return random
    }


    fun chanceCounter(nr: Int){
        var corNr = nr - 1
        percentValHigh = 13 - corNr.toDouble()
        percentValHigh /= 13
        percentValHigh *= 100
        if(corNr == 13){
            percentValLow = 0.0
        }
        var percentAmount = percentValHigh.toBigDecimal().setScale(1, RoundingMode.UP)
        binding.higherChance.text = "$percentAmount%"
        percentValLow = corNr.toDouble()/13
        percentValLow *= 100
        if(corNr == 1){
            percentValLow = 0.0
        }
        percentAmount = percentValLow.toBigDecimal().setScale(1, RoundingMode.UP)
        binding.lowerChance.text = "$percentAmount%"

    }

    fun reset() {
        binding.loseText.text = ""
        binding.inARowText.text = ""
        binding.cardBack.setImageResource(R.drawable.gray_back)
        idNr = 0
        inARow = 0
    }

    fun gameLost(){
        binding.loseText.text = "You lost"
        binding.lowerChance.text = ""
        binding.higherChance.text = ""
    }

    fun roundProgression(curNr: Int ){
        chanceCounter(curNr)
        lastNr = curNr
        inARow++
        binding.inARowText.text = "$inARow in a row"
    }
}
