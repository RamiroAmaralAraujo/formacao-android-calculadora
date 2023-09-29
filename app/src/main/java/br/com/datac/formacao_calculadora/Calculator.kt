package br.com.datac.formacao_calculadora

class Calculator(
    val n1: Double,
    val n2: Double
) {

    fun somar(): Double{
        return n1 + n2
    }

    fun subtrair(): Double{
        return n1 - n2
    }

    fun multiplicar(): Double{
        return n1 * n2
    }

    fun dividir(): Double{
        return n1 / n2
    }

}