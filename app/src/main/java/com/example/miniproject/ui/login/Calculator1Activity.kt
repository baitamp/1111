package com.example.miniproject.ui.login


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.miniproject.R

class Calculator1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator1)

        val num1: TextView = findViewById(R.id.num1)
        val sym: TextView = findViewById(R.id.sym)
        val num2: TextView = findViewById(R.id.num2)
        val num3: TextView = findViewById(R.id.num3)
        val btplus: Button = findViewById(R.id.btplus)
        val btminus: Button = findViewById(R.id.btminus)
        val btmultiply: Button = findViewById(R.id.btmultiply)
        val btdivider: Button = findViewById(R.id.btdivider)
        val btmodulo: Button = findViewById(R.id.btmodulo)
        val btclear: Button = findViewById(R.id.btclear)

        var x:String = ""
        var y:String = ""
        var z = 0



        btplus.setOnClickListener {
            x = num1.text.toString()
            y = num2.text.toString()

            if(x == "" || y== ""){
                Toast. makeText(applicationContext,"กรุณากรอกให้ครบ",Toast. LENGTH_SHORT).show()
            }else{
                sym.setText("+")
                z = x.toInt() + y.toInt()
                num3.setText(z.toString())
            }
        }

        btminus.setOnClickListener {
            x = num1.text.toString()
            y = num2.text.toString()

            if(x == "" || y== ""){
                Toast. makeText(applicationContext,"กรุณากรอกให้ครบ",Toast. LENGTH_SHORT).show()
            }else{
                sym.setText("-")
                z = x.toInt() - y.toInt()
                num3.setText(z.toString())
            }
        }

        btmultiply.setOnClickListener {
            x = num1.text.toString()
            y = num2.text.toString()

            if(x == "" || y== ""){
                Toast. makeText(applicationContext,"กรุณากรอกให้ครบ",Toast. LENGTH_SHORT).show()
            }else{
                sym.setText("*")
                z = x.toInt() * y.toInt()
                num3.setText(z.toString())
            }
        }

        btdivider.setOnClickListener {
            x = num1.text.toString()
            y = num2.text.toString()

            if(x == "" || y== ""){
                Toast. makeText(applicationContext,"กรุณากรอกให้ครบ",Toast. LENGTH_SHORT).show()
            }else{
                sym.setText("/")
                z = x.toInt() / y.toInt()
                num3.setText(z.toString())
            }
        }

        btmodulo.setOnClickListener {
            x = num1.text.toString()
            y = num2.text.toString()

            if(x == "" || y == "") {
                Toast.makeText(applicationContext, "กรุณากรอกให้ครบ", Toast.LENGTH_SHORT).show()
            }else{
                sym.setText("%")
                z = x.toInt() % y.toInt()
                num3.setText(z.toString())
            }
        }


        btclear.setOnClickListener {
            num1.setText("")
            sym.setText("")
            num2.setText("")
            num3.setText("")
        }

    }
}