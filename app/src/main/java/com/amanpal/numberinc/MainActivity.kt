package com.amanpal.numberinc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumberToButton()

        btnleft.setOnClickListener {
            checkAnswer(true)
            assignNumberToButton()
        }


        btnright.setOnClickListener {
            checkAnswer(false)
            assignNumberToButton()
        }
    }


    private fun checkAnswer(isLeftButtonClicked : Boolean) {
        var count = count_score.text.toString().toInt()
        val leftNum = btnleft.text.toString().toInt()
        val rightNum = btnright.text.toString().toInt()
        val isAnswerCorrect : Boolean = if (isLeftButtonClicked) leftNum > rightNum else rightNum > leftNum

//          1.show toast and change background color
        if (isAnswerCorrect){

            background_view.setBackgroundColor(Color.GREEN)
            count++
            count_score.text = count.toString()
        }
        else {

            background_view.setBackgroundColor(Color.RED)
            count--
            count_score.text = count.toString()
        }
    }
    private fun assignNumberToButton() {
        val random = Random()
        val leftNum = random.nextInt(50)

        var rightNum = leftNum
        while (rightNum == leftNum){
            rightNum = random.nextInt(50)
        }

        btnleft.text = leftNum.toString()
        btnright.text = rightNum.toString()
    }
}



