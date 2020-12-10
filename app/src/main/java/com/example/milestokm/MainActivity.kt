package com.example.milestokm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val milesText = findViewById<EditText>(R.id.MilesWindow)
        val kmText = findViewById<EditText>(R.id.KmWindow)



        milesText.doOnTextChanged { text, _, _, _ ->
             var resKm = printRes(milesText.text.toString().toInt())
             kmText.hint = "$resKm"
        }

        kmText.doOnTextChanged { text, _, _, _ ->
            var resM = printResM(kmText.text.toString().toInt())
            milesText.hint = "$resM"
        }


    }

    private fun printRes(x: Int): Int {
        var m = x
        var km = m / 0.621
        return km.toInt()

    }

    private fun printResM(x: Int): Int {
        var km = x
        var m = km / 1.609
        return m.toInt()
    }
}