package com.example.cardgame

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cardgame.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.dayNight.setOnClickListener {
            val intent = Intent(this,DarkMode::class.java)
            startActivity(intent)
        }

        binding.higherBtn.setOnClickListener {
            imageSelect(binding.cardFront)
        }
        binding.lowerBtn.setOnClickListener {
            imageSelect(binding.cardFront)
        }

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun imageSelect(imageView: ImageView):Int {
        var random : Int
        var idNr : Int
        var id : String
        random = kotlin.random.Random.nextInt(1,4)
        if(random == 1) {
            random = kotlin.random.Random.nextInt(2,14)
            id = "c$random"
            idNr = this.resources.getIdentifier(id, "drawable", packageName)
            imageView.setImageResource(idNr)
        } else if (random == 2){
            random = kotlin.random.Random.nextInt(2,14)
            id = "d$random"
            idNr = this.resources.getIdentifier(id, "drawable", packageName)
            imageView.setImageResource(idNr)
        }else if(random == 3){
            random = kotlin.random.Random.nextInt(2,14)
            id = "h$random"
            idNr = this.resources.getIdentifier(id, "drawable", packageName)
            imageView.setImageResource(idNr)
        }else{
            random = kotlin.random.Random.nextInt(2,14)
            id = "s$random"
            idNr = this.resources.getIdentifier(id, "drawable", packageName)
            imageView.setImageResource(idNr)
        }
        return random
    }
}
