package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val text1: TextView = findViewById(R.id.textView)
        val roll = Dice(6).roll()
        text1.text = roll.toString()
        val image: ImageView = findViewById(R.id.imageView)
        val d_resource = when(roll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image.setImageResource(d_resource)
        image.contentDescription = roll.toString()

    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}