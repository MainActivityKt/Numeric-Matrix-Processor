package matrixprocessor

import utils.Utils.getMatrixFromInput
import utils.Utils.printMatrix
import java.util.Scanner

class MatrixMultiplier {
    private val sc = Scanner(System.`in`)
    private lateinit var matrix: List<MutableList<Int>>

    fun initializeMatrix() {
        matrix = getMatrixFromInput(sc)
    }

    fun performMultiplication() {
        val multiplier = sc.nextInt()
        matrix.forEach {
            it times multiplier
        }
    }

    fun printMatrix() {
        matrix.printMatrix()
    }
}

infix fun MutableList<Int>.times(multiplier: Int): MutableList<Int> {
    this.forEachIndexed { i, _ ->
        this[i] *= multiplier
    }
    return this
}

fun main() {
    val multiplier = MatrixMultiplier()
    multiplier.initializeMatrix()
    multiplier.performMultiplication()
    multiplier.printMatrix()
}