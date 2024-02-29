package com.example.miniproject.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.R

class Calculator2Activity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var currentInput: String = ""
    private var currentOperator: String? = ""
    private var firstOperand: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator2)

        textView = findViewById(R.id.textView)

        val numberButtons = arrayOf(
            R.id.button17, R.id.button13, R.id.button14, R.id.button15, R.id.button9,
            R.id.button11, R.id.button10, R.id.button5, R.id.button6,
            R.id.button7, R.id.button18
        )

        for (buttonId in numberButtons) {
            findViewById<Button>(buttonId).setOnClickListener {
                onNumberButtonClick(it)
            }
        }

        findViewById<Button>(R.id.clear).setOnClickListener {
            onDeleteButtonClick()
        }

        findViewById<Button>(R.id.allClear).setOnClickListener {
            clearAll()
        }

        val operatorButtons = arrayOf(
            R.id.Plus, R.id.Minus, R.id.Multiply, R.id.Divide, R.id.Modulo
        )

        for (buttonId in operatorButtons) {
            findViewById<Button>(buttonId).setOnClickListener {
                onOperatorButtonClick(it)
            }
        }

        findViewById<Button>(R.id.Equal).setOnClickListener {
            onEqualsButtonClick()
        }
    }

    private fun clearAll() {
        currentInput = "0"
        currentOperator = null
        firstOperand = null
        updateResult()
    }

    private fun onNumberButtonClick(view: View) {
        val buttonText = (view as Button).text.toString()

        if (currentInput == "0") {
            currentInput = buttonText
        } else {
            currentInput += buttonText
        }

        updateResult()
    }

    private fun onDeleteButtonClick() {
        if (currentInput.length > 1) {
            currentInput = currentInput.substring(0, currentInput.length - 1)
        } else {
            currentInput = "0"
        }

        updateResult()
    }

    private fun onOperatorButtonClick(view: View) {
        currentOperator = (view as Button).text.toString()
        if (firstOperand == null) {
            firstOperand = currentInput.toDouble()
        } else {
            onEqualsButtonClick()
            currentOperator = (view as Button).text.toString()
        }
        currentInput = "0"
    }

    private fun onEqualsButtonClick() {
        if (currentOperator != null && firstOperand != null) {
            val secondOperand = currentInput.toDouble()
            val result = when (currentOperator) {
                "+" -> firstOperand!! + secondOperand
                "-" -> firstOperand!! - secondOperand
                "X" -> firstOperand!! * secondOperand
                "/" -> firstOperand!! / secondOperand
                "%" -> firstOperand!! % secondOperand
                else -> throw IllegalArgumentException("Invalid operator")
            }

            currentInput = result.toString()
            firstOperand = result

            updateResult()
        }
    }

    private fun updateResult() {
        textView.text = currentInput
    }
}
