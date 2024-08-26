package matrixprocessor

import utils.Utils.getMatrixFromInput
import utils.Matrix
import java.util.Scanner

class MatrixMultiplier {
    private val sc = Scanner(System.`in`)
    private lateinit var matrix: Matrix

    fun initializeMatrix() {
        matrix = getMatrixFromInput(sc)
    }

    fun performMultiplication() {
        val multiplier = sc.nextInt()
        matrix.multiply(multiplier.toDouble())
    }

    fun printMatrix() {
        println(matrix)
    }
}



fun main() {
    val multiplier = MatrixMultiplier()
    multiplier.initializeMatrix()
    multiplier.performMultiplication()
    multiplier.printMatrix()
}