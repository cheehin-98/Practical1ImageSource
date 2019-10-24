package com.example.practical1imagesource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView
    lateinit var diceImage3: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)

        val rollbutton: Button = findViewById(R.id.roll_button)
        rollbutton.setOnClickListener{rollDice()}
        val countupbutton: Button =findViewById(R.id.countup_button)
        countupbutton.setOnClickListener{countup()}
    }
    private fun rollDice() {
        Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()

        val randomInt1 = Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6) + 1
        val randomInt3 = Random().nextInt(6) + 1

        diceImage1.setImageResource(DiceNum(randomInt1))
        diceImage2.setImageResource(DiceNum(randomInt2))
        diceImage3.setImageResource(DiceNum(randomInt3))
    }
    private fun DiceNum(diceNum:Int):Int{
        val drawableResource = when (diceNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
    private fun countup() {
        try {
            Toast.makeText(this, "Dices Total Value Counted", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Roll Dice First", Toast.LENGTH_SHORT).show()
        }
    }
}
