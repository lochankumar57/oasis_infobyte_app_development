package com.example.calculator

import android.*
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.Type

class MainActivity2 : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var r = "hello"
        var itemselected =""
        var itemselected1 = ""
        val resultTextView1 = findViewById<TextView>(R.id.textView1)
        val input = findViewById<TextView>(R.id.textView2)
        val result = findViewById<TextView>(R.id.textView3)

        val items = listOf("meters","kilometers","grams","kilograms","liters","kiloliters","centimeters","feet,inches")
        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_item,items)

        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->
            itemselected1 = adapterView.getItemAtPosition(i) as String
        }

        val items1 = listOf("meters","kilometers","grams","kilograms","liters","kiloliters","centimeters","feet,inches")
        val autoComplete1 : AutoCompleteTextView = findViewById(R.id.auto_complete1)

        val adapter1 = ArrayAdapter(this,R.layout.list_item,items1)

        autoComplete1.setAdapter(adapter1)
        autoComplete1.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView, view, i, l ->
            itemselected = adapterView.getItemAtPosition(i) as String
        }

        val editText1 = findViewById<EditText>(R.id.editText1)
        val calculateButton1 = findViewById<Button>(R.id.button1)
        calculateButton1.setOnClickListener{
            if(itemselected=="kilometers" && itemselected1=="meters")
            {
                val n = editText1.text.toString().toDouble()
                val r = n*1000
                resultTextView1.text = "$r $itemselected1"
            }
            else if(itemselected=="meters" && itemselected1=="kilometers")
            {
                val n = editText1.text.toString().toDouble()
                val r = n/1000
                resultTextView1.text = "$r $itemselected1"
            }
            else if(itemselected=="grams" && itemselected1=="kilograms")
            {
                val n = editText1.text.toString().toDouble()
                val r = n*1000
                resultTextView1.text = "$r $itemselected1"
            }
            else if(itemselected=="kilograms" && itemselected1=="grams")
            {
                val n = editText1.text.toString().toDouble()
                val r = n/1000
                resultTextView1.text = "$r $itemselected1"
            }
            else if(itemselected=="centimeters" && itemselected1=="feet,inches")
            {
                val cm = editText1.text.toString().toDouble()
                val (feet, inches) = convertCmToFeetAndInches(cm)
                resultTextView1.text = "$feet feet $inches inches"
            }
            else if(itemselected=="feet,inches" && itemselected1=="centimeters")
            {
                val n = editText1.text.toString().toDouble()
                val r = n * 30.48
                resultTextView1.text = "$r $itemselected1"
            }
            else
            {

                resultTextView1.text = "!!!!wrong units!!!!"
            }
        }
    }
    fun convertCmToFeetAndInches(cm: Double): Pair<Int, Double>
    {
        val feet = (cm / 30.48).toInt()
        val inches = ((cm / 2.54 - feet * 12) * 10).roundToInt() / 10.0
        return Pair(feet, inches)
    }
    fun Double.roundToInt(): Int
    {
        return this.toInt()
    }
    fun Double.roundTo(n: Int): Double
    {
        return "%.${n}f".format(this).toDouble()
    }


}