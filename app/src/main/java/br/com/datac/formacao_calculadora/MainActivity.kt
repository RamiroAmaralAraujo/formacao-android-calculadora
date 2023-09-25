package br.com.datac.formacao_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById(R.id.editTextText1) as EditText
        val num2 = findViewById(R.id.editTextText2) as EditText
        val total = findViewById(R.id.textViewResultado) as TextView
        val button = findViewById(R.id.buttonTotal) as Button
        val operatorList = findViewById(R.id.spinner) as Spinner
        var operatorConverted = operatorList.toString()


        var operator = arrayOf("Selecione o operador da expressão","+", "-", "/", "*")
        operatorList.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operator)

        operatorList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                operatorConverted = operator[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        button.setOnClickListener{
            val val1 = num1.text.toString().toDouble()
            val val2 = num2.text.toString().toDouble()

            if (operatorConverted == "+") {
                    val result = val1 + val2
                    total.setText(result.toString())
             } else if (operatorConverted == "-") {
                val result = val1 - val2
                total.setText(result.toString())
            }else if (operatorConverted == "*") {
                val result = val1 * val2
                total.setText(result.toString())
            }else if (operatorConverted == "/") {
                val result = val1 / val2
                total.setText(result.toString())
            }
            else{
                total.text= "Por favor, selecione um operador válido"
            }
        }
    }
}