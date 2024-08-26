package utils

import java.util.Scanner

class Matrix(width: Int, height: Int, sc: Scanner = Scanner(System.`in`)) {
    private var matrix: List<MutableList<Double>> = MutableList(height) { MutableList(width) { 0.0 } }
    val numOfRows = height
    val numOfColumns = width

    init {
        for (y in 0..<height) {
            for (x in 0..<width) {
                matrix[y][x] = sc.nextDouble()
            }
        }
    }

    private val columns: List<List<Double>>
        get() {
            val list = List(matrix.first().size) { mutableListOf<Double>() }
            for (i in 0..matrix.first().lastIndex) {
                matrix.forEach {
                    list[i].add(it[i])
                }
            }
            return list
        }

    fun add(otherMatrix: Matrix) {
        for (y in 0..<numOfColumns) {
            for (x in 0..<numOfRows) {
                matrix[y][x] = matrix[y][x] + otherMatrix.get(y, x)
            }
        }
    }

    fun multiply(multiplier: Double) {
        matrix.forEach { row ->
            row.forEachIndexed { index, value ->
                row[index] = value * multiplier
            }
        }
    }

    fun multiply(otherMatrix: Matrix) {
        val result = List(numOfRows) { MutableList(otherMatrix.numOfColumns) { 0.0 } }
        matrix.forEachIndexed { x, row ->
            otherMatrix.columns.forEachIndexed { y, column ->
                val sum = row.mapIndexed { index, value -> value * column[index] }.sum()
                result[x][y] = sum
            }
        }
        matrix = result
    }

    override fun toString(): String {
        val printInInt = matrix.sumOf { it.sum() } % 1.0 == 0.0
        return buildString {
            matrix.forEach { row ->
                appendLine(if (printInInt) row.map { it.toInt() }.joinToString(" ") else row.joinToString(" "))
            }
        }
    }

    fun get(x: Int, y: Int): Double {
        return matrix[x][y]
    }
}

object Utils {
    enum class Operation(val value: String) {
        ADD_MATRICES("Add matrices"), MULTIPLY_MATRIX_BY_CONSTANT("Multiply matrix by a constant") ,
        MULTIPLY_MATRICES("Multiply matrices"), EXIT("Exit")
    }

    val menuItems = mapOf(
        Operation.ADD_MATRICES to 1,
        Operation.MULTIPLY_MATRIX_BY_CONSTANT to 2,
        Operation.MULTIPLY_MATRICES to 3,
        Operation.EXIT to 0,
    )
    fun getMatrixFromInput(scanner: Scanner, getDetailsMessage: String? = null, getMatrixMessage: String? = null): Matrix {
        getDetailsMessage?.let { print(it) }
        val matrixHeight = scanner.nextInt()
        val matrixWidth = scanner.nextInt()
        getMatrixMessage?.let { println(it) }
        return Matrix(matrixWidth, matrixHeight)
    }
}
