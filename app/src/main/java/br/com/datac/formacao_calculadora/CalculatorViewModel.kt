package br.com.datac.formacao_calculadora

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    private val _resultLiveData: MutableLiveData<Double> = MutableLiveData()
    val resultLiveData: LiveData<Double> = _resultLiveData

    fun runOperation(
        operatorConverted: String,
        val1: Double,
        val2: Double
    ) {
        try{
            var result = 0.0
            val calc = Calculator(val1, val2)
            when (operatorConverted) {
                "+" -> {
                    result = calc.somar()
                }
                "-" -> {
                    result = calc.subtrair()
                }
                "*" -> {
                    result = val1 * val2
                }
                "/" -> {
                    result = val1 / val2
                }
                else -> {

                }
            }
            _resultLiveData.value = result
        }catch(e: Exception){

        }
    }
}