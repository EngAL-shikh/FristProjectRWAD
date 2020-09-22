package com.example.fristprojectrwad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private   val  qustionBank= listOf(

        Qustion(R.string.fristQ,true,""),
        Qustion(R.string.q2,true,"")  ,
        Qustion(R.string.q3,true,""),
        Qustion(R.string.q4,false,"")


    )
    var Tanswer:Int=0
    var Fanswer:Int=0

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//=======================show result====================================

        showresult.setOnClickListener {

            if (Fanswer+Tanswer==4){



                Toast.makeText(this,"4/" +Tanswer, Toast.LENGTH_SHORT).show()
            }
            if (Tanswer==4){


                Toast.makeText(this,"4/"  +Tanswer, Toast.LENGTH_SHORT).show()

            }

        }



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

        if (Fanswer+Tanswer==4){

            showresult.visibility=View.VISIBLE


        }
        if (Tanswer==4){
            showresult.visibility=View.VISIBLE



        }

        if (currentIndex==3){
            currentIndex=(currentIndex - 4)


        }

        if (qustionBank[currentIndex+1].status=="" ){
            bt_false.isClickable=true
            bt_true.isClickable=true
            bt_true.setBackgroundResource(R.drawable.trueshape)
            bt_false.setBackgroundResource(R.drawable.falseshape)

            currentIndex = (currentIndex + 1) % qustionBank.size
            val questionTextResId = qustionBank[currentIndex].restTextid
            tv_qustion.setText(questionTextResId)
            tv_qustion.setBackgroundResource(R.drawable.qshape)
        }else{

            bt_false.isClickable=false
            bt_true.isClickable=false
            bt_true.setBackgroundResource(R.drawable.answerd)
            bt_false.setBackgroundResource(R.drawable.answerd)
            currentIndex = (currentIndex + 1) % qustionBank.size
            val questionTextResId = qustionBank[currentIndex].restTextid
            tv_qustion.setText(questionTextResId)
            tv_qustion.setBackgroundResource(R.drawable.qshape)
        }
        }


    //===================== Privuse Quastion ===================================


    private fun privQ() {

        if (currentIndex==0){
            currentIndex=(currentIndex + 4)


        }

        if (qustionBank[currentIndex-1].status=="" ){


            bt_false.isClickable=true
            bt_true.isClickable=true
            bt_true.setBackgroundResource(R.drawable.trueshape)
            bt_false.setBackgroundResource(R.drawable.falseshape)
            if (currentIndex==0){
                currentIndex=(currentIndex + 4)


            }
            currentIndex = (currentIndex - 1) % qustionBank.size
            val questionTextResId = qustionBank[currentIndex].restTextid
            tv_qustion.setText(questionTextResId)
            tv_qustion.setBackgroundResource(R.drawable.qshape)

        }else{

            bt_false.isClickable=false
            bt_true.isClickable=false
            bt_true.setBackgroundResource(R.drawable.answerd)
            bt_false.setBackgroundResource(R.drawable.answerd)


            currentIndex = (currentIndex - 1) % qustionBank.size
            val questionTextResId = qustionBank[currentIndex].restTextid
            tv_qustion.setText(questionTextResId)
            tv_qustion.setBackgroundResource(R.drawable.qshape)

        }



    }




    //===================== check answer function ====================================

    private fun checkAnswer(userAnswer: Boolean) {


        val correctAnswer = qustionBank[currentIndex].answer
        if (userAnswer == correctAnswer) {



            qustionBank[currentIndex].status="1"

            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
            tv_qustion.setBackgroundResource(R.drawable.qtrue)
            bt_true.setBackgroundResource(R.drawable.answerd)
            bt_false.setBackgroundResource(R.drawable.answerd)
            bt_false.isClickable=false
            bt_true.isClickable=false

                Tanswer++




        } else {

            qustionBank[currentIndex].status="0"

            bt_false.isClickable=false
            bt_true.isClickable=false
            bt_true.setBackgroundResource(R.drawable.answerd)
            bt_false.setBackgroundResource(R.drawable.answerd)
            Fanswer++
            Toast.makeText(this, R.string.False, Toast.LENGTH_SHORT).show()

            tv_qustion.setBackgroundResource(R.drawable.qfalse)

        }







    }
}
