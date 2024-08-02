package matrixprocessor

import utils.Utils.getMatrixFromInput
import utils.Utils.printMatrix
import java.util.Scanner

class MatrixAddition {
    private val sc = Scanner(System.`in`)
    private lateinit var firstMatrix: List<List<Int>>
    private lateinit var secondMatrix: List<List<Int>>
    private lateinit var additionMatrix: List<List<Int>>

    fun initializeMatrices() {
        firstMatrix = getMatrixFromInput(sc)
        secondMatrix = getMatrixFromInput(sc)
    }

    fun performAddition() {
        if (firstMatrix.size == secondMatrix.size && firstMatrix.first().size == secondMatrix.first().size) {
            additionMatrix = firstMatrix plus secondMatrix
        }
    }

    fun printMatrix() {
        if (this::additionMatrix.isInitialized) {
            additionMatrix.printMatrix()
        } else {
            println("ERROR")
        }
    }
}

infix fun List<List<Int>>.plus(other: List<List<Int>>): List<List<Int>> {
    val height = this.size
    val width = this.first().size
    val list = MutableList(height) { MutableList(width) { 0 } }
    for (y in 0..<height) {
        for (x in 0..<width) {
            list[y][x] = this[y][x] + other[y][x]
        }
    }
    return list
}

fun main() {
    val addition = MatrixAddition()
    addition.initializeMatrices()
    addition.performAddition()
    addition.printMatrix()
}