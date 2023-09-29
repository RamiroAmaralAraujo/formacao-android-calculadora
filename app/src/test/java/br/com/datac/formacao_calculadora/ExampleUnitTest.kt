package br.com.datac.formacao_calculadora

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val result = Calculator(1.0, 2.0).somar().toInt()
        assertEquals(3, result)
    }
}