package com.example.calculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var edtInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtInput = findViewById(R.id.edtInput)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnAdd, R.id.btnSub, R.id.btnMul,
            R.id.btnDiv, R.id.btnDot
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                edtInput.append((it as Button).text)
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            edtInput.setText("")
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        try {
            val expr = edtInput.text.toString()

            if (expr.contains("/0")) {
                Toast.makeText(this, "Divide by zero error", Toast.LENGTH_SHORT).show()
                return
            }

            val result = evaluate(expr)
            Toast.makeText(this, "Result = $result", Toast.LENGTH_LONG).show()

        } catch (e: Exception) {
            Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show()
        }
    }

    private fun evaluate(expression: String): Double {
        val tokens = Regex("(?<=[-+*/])|(?=[-+*/])").split(expression)
        var result = tokens[0].toDouble()
        var i = 1

        while (i < tokens.size) {
            val operator = tokens[i]
            val number = tokens[i + 1].toDouble()

            when (operator) {
                "+" -> result += number
                "-" -> result -= number
                "*" -> result *= number
                "/" -> result /= number
            }
            i += 2
        }
        return result
    }
}
