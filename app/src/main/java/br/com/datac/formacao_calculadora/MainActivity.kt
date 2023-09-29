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

    val viewModel = CalculatorViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.editTextText1)
        val num2: EditText = findViewById(R.id.editTextText2)
        val textViewTotal = findViewById<TextView>(R.id.textViewResultado)
        val button = findViewById<Button>(R.id.buttonTotal)
        val operatorList = findViewById<Spinner>(R.id.spinner)
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
            viewModel.runOperation(operatorConverted, val1, val2 )
        }

        viewModel.resultLiveData.observe(this) {
            textViewTotal.text = it.toString()
        }

    }




}