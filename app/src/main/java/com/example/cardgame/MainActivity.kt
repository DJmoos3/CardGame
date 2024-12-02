package com.example.cardgame

import android.content.Intent
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

    //lateinit var binding: ActivityMainBinding
    /*var idNr = 0
    var percentValHigh = 0.0
    var percentValLow = 0.0
    var inARow = 0
    var lastNr = 1
    var curNr = 0*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //binding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView(binding.root)

        initiator(binding.higherChance,binding.lowerChance,binding.loseText,binding.inARowText,
            binding.cardFront,binding.cardBack,binding.lowerBtn,binding.higherBtn,binding.replay)

        binding.dayNight.setOnClickListener {
            val intent = Intent(this,DarkMode::class.java)
            startActivity(intent)
        }

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

    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)


    /*fun imageSelect(imageView: ImageView):Int {
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
    }*/


    /*fun chanceCounter(nr: Int){
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

    }*/

    /*fun reset() {
        binding.loseText.text = ""
        binding.inARowText.text = ""
        binding.cardFront.setImageDrawable(null)
        binding.cardBack.setImageResource(R.drawable.gray_back)
        idNr = 0
        inARow = 0
        binding.lowerBtn.isEnabled = true
        binding.higherBtn.isEnabled = true
    }

    fun gameLost(){
        binding.loseText.text = "You lost"
        binding.lowerChance.text = ""
        binding.higherChance.text = ""
        binding.replay.isInvisible = false
        binding.replay.isEnabled = true
        binding.lowerBtn.isEnabled = false
        binding.higherBtn.isEnabled = false
    }

    fun roundProgression(curNr: Int ){
        chanceCounter(curNr, binding.higherChance, binding.lowerChance)
        lastNr = curNr
        inARow++
        binding.inARowText.text = "$inARow in a row"
    }

    fun onClick(lowHigh : String){
        if (idNr != 0) {
            binding.cardBack.setImageResource(idNr)
        }
        if (lastNr != curNr && lowHigh == "low"){
            lastNr = 15
        }
        if (lastNr != curNr && lowHigh == "high"){
            lastNr = 0
        }
        curNr = imageSelect(binding.cardFront)
        if (curNr > lastNr && lowHigh == "low"){
            gameLost()
        }else if (curNr < lastNr && lowHigh == "high") {
            gameLost()
        }else {
            roundProgression(curNr)
        }
    }*/
}
