package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val calculateButton = findViewById<Button>(R.id.button)
        val resultTextView = findViewById<TextView>(R.id.textView)
        val conversion = findViewById<Button>(R.id.button2)
        conversion.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        calculateButton.setOnClickListener {
            val expression = editText.text.toString()

            val result = try
            {
                val expressionResult = ExpressionBuilder(expression).build().evaluate()
                expressionResult.toString()
            }
            catch (e: Exception)
            {
                "Error: ${e.message}"
            }
            resultTextView.text = result
        }
    }
}