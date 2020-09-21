package com.example.fristprojectrwad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private   val  qustionBank= listOf(

        Qustion(R.string.fristQ,true),
        Qustion(R.string.q2,true)  ,
        Qustion(R.string.q3,true),
        Qustion(R.string.q4,false)


    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //=======trueBT=================
        bt_true.setOnClickListener {
            checkAnswer(true)
        }

        //=======falseBT=================
        bt_false.setOnClickListener {
            checkAnswer(false)
        }




        //=======Next quastion=================
        tv_qustion.setOnClickListener {

            updateQuestion()
        }
        tv_qustion.setText(qustionBank[0].restTextid)

        bt_next.setOnClickListener {

            updateQuestion()

        }
        imnext.setOnClickListener {

            updateQuestion()

        }

        //=======previous=================
        previous.setOnClickListener {

            privQ()
        }
        imprev.setOnClickListener {

            privQ()
        }










    }


    //===================== Next Quastion ===================================
    private fun updateQuestion() {
        currentIndex = (currentIndex + 1) % qustionBank.size
        val questionTextResId = qustionBank[currentIndex].restTextid
        tv_qustion.setText(questionTextResId)
        tv_qustion.setBackgroundResource(R.drawable.qshape)
           }

    //===================== Privuse Quastion ===================================


    private fun privQ() {

        if (currentIndex==0){
            currentIndex=(currentIndex + 4)


        }
        currentIndex = (currentIndex - 1) % qustionBank.size
        val questionTextResId = qustionBank[currentIndex].restTextid
        tv_qustion.setText(questionTextResId)
        tv_qustion.setBackgroundResource(R.drawable.qshape)
    }




    //===================== check answer function ====================================

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = qustionBank[currentIndex].answer
        if (userAnswer == correctAnswer) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
          tv_qustion.setBackgroundResource(R.drawable.qtrue)


        } else {
            Toast.makeText(this, R.string.False, Toast.LENGTH_SHORT).show()

            tv_qustion.setBackgroundResource(R.drawable.qfalse)

        }


    }
}
