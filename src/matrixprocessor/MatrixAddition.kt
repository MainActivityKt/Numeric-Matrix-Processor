package matrixprocessor

import java.util.Scanner

class MatrixAddition {
    private val sc = Scanner(System.`in`)
    private lateinit var firstMatrix: List<List<Int>>
    private lateinit var secondMatrix: List<List<Int>>

    fun initializeMatrices() {
        var height = sc.nextInt()
        var width = sc.nextInt()
        firstMatrix = initializeMatrix(height, width)
        height = sc.nextInt()
        width = sc.nextInt()
        secondMatrix = initializeMatrix(height, width)
    }

    private fun initializeMatrix(height: Int, width: Int): List<List<Int>> {
        val matrix = MutableList(height) { MutableList(width) { 0 } }
        for (y in 0..<height) {
            for (x in 0..<width) {
                matrix[y][x] = sc.nextInt()
            }
        }
        return matrix
    }

    fun getMatricesAddition(): String {
        if (firstMatrix.size != secondMatrix.size || firstMatrix.first().size != secondMatrix.first().size) {
            return "ERROR"
        }
        val additionMatrix = firstMatrix plus secondMatrix
        StringBuilder().apply {
            additionMatrix.forEach {
                append(it.joinToString(" "))
                append("\n")
            }
            return this.toString()
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
    println(addition.getMatricesAddition())
}