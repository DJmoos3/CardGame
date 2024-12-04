package com.example.cardgame

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.viewbinding.ViewBinding
import com.example.cardgame.databinding.ActivityMainBinding
import java.math.RoundingMode

abstract class BaseActivity <VB: ViewBinding> : AppCompatActivity() {

    lateinit var binding : VB

    /*lateinit var higherChance : TextView
    lateinit var lowerChance : TextView
    lateinit var loseText : TextView
    lateinit var inARowText : TextView

    lateinit var cardFront : ImageView
    lateinit var cardBack : ImageView

    lateinit var lowerBtn : Button
    lateinit var higherBtn : Button
    lateinit var replay : Button

    var idNr = 0
    var percentValHigh = 0.0
    var percentValLow = 0.0
    var inARow = 0
    var lastNr = 1
    var curNr = 0


*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBinding()
        setContentView(binding.root)

    }

    abstract fun inflateBinding():VB

    fun checkIfDark(darkMode : Boolean, main : View,
                    frameLayout: FrameLayout, dayNight : Switch){
        if(darkMode) {
            main.setBackgroundColor(resources.getColor(R.color.black))
            frameLayout.setBackgroundColor(Color.parseColor("#8E8E8E"))
            dayNight.text = "\uD83C\uDF11"
            dayNight.isChecked = true
        }else{
            main.setBackgroundColor(resources.getColor(R.color.white))
            frameLayout.setBackgroundColor(Color.parseColor("#ececec"))
            dayNight.text = "\u2600"
            dayNight.isChecked = false
        }
    }


    /*fun initiator(higherChanceInit: TextView, lowerChanceInit: TextView, loseTextInit: TextView,
                  inARowTextInit : TextView, cardFrontInit : ImageView, cardBackInit : ImageView,
                  lowerBtnInit : Button, higherBtnInit : Button, replayInit : Button) {
        higherChance = higherChanceInit
        lowerChance = lowerChanceInit
        loseText = loseTextInit
        inARowText = inARowTextInit
        cardFront = cardFrontInit
        cardBack = cardBackInit
        lowerBtn = lowerBtnInit
        higherBtn = higherBtnInit
        replay = replayInit
    }

    fun setVariables(higherChanceTxt : String, lowerChanceTxt : String, loseTextTxt: String,
                     inARowTextTxt : String, cardFrontIdNr : Int, cardBackIdNr : Int,
                     lowerBtnBool : Boolean, higherBtnBool : Boolean, replayBool : Boolean) {
        higherChance.text = higherChanceTxt
        lowerChance.text = lowerChanceTxt
        loseText.text = loseTextTxt
        inARowText.text = inARowTextTxt
        cardFront.setImageResource(cardFrontIdNr)
        cardBack.setImageResource(cardBackIdNr)
        lowerBtn.isEnabled = lowerBtnBool
        higherBtn.isEnabled = higherBtnBool
        replay.isEnabled = replayBool
        replay.isInvisible != replayBool
    }

    private fun imageSelect(imageView: ImageView):Int {
        var random = kotlin.random.Random.nextInt(1,4)
        var id : String
        if(random == 1) {
            id = "c"
        }else if(random == 2) {
            id = "d"
        }else if(random == 3) {
            id = "h"
        }else {
            id = "s"
        }
        random = kotlin.random.Random.nextInt(2,15)
        id += random
        idNr = resources.getIdentifier(id, "drawable", packageName)
        imageView.setImageResource(idNr)
        return random
    }

    private fun chanceCounter(nr: Int){
        var corNr = nr - 1
        percentValHigh = 13 - corNr.toDouble()
        percentValHigh /= 13
        percentValHigh *= 100
        if(corNr == 13){
            percentValLow = 0.0
        }
        var percentAmount = percentValHigh.toBigDecimal().setScale(1, RoundingMode.UP)
        higherChance.text = "$percentAmount%"
        percentValLow = corNr.toDouble()/13
        percentValLow *= 100
        if(corNr == 1){
            percentValLow = 0.0
        }
        percentAmount = percentValLow.toBigDecimal().setScale(1, RoundingMode.UP)
        lowerChance.text = "$percentAmount%"

    }

    fun reset() {
        loseText.text = ""
        inARowText.text = ""
        cardFront.setImageDrawable(null)
        cardBack.setImageResource(R.drawable.gray_back)
        idNr = 0
        inARow = 0
        lowerBtn.isEnabled = true
        higherBtn.isEnabled = true
    }

    private fun gameLost(){
        loseText.text = "You lost"
        lowerChance.text = ""
        higherChance.text = ""
        replay.isInvisible = false
        replay.isEnabled = true
        lowerBtn.isEnabled = false
        higherBtn.isEnabled = false
    }

    private fun roundProgression(curNr: Int ){
        chanceCounter(curNr)
        lastNr = curNr
        inARow++
        inARowText.text = "$inARow in a row"
    }

    fun onClick(lowHigh : String){
        if (idNr != 0) {
            cardBack.setImageResource(idNr)
        }
        if (lastNr != curNr && lowHigh == "low"){
            lastNr = 15
        }
        if (lastNr != curNr && lowHigh == "high"){
            lastNr = 0
        }
        curNr = imageSelect(cardFront)
        if (curNr > lastNr && lowHigh == "low"){
            gameLost()
        }else if (curNr < lastNr && lowHigh == "high") {
            gameLost()
        }else {
            roundProgression(curNr)
        }
    }
    fun getIdNr(frontOrBack : String):Int{
        if (frontOrBack == "front"){
            return idNr
        }else{
            return lastNr
        }
    }*/

}