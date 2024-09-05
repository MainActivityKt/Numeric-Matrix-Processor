package utils

import java.util.Scanner

class Matrix {
    private val matrix: List<List<Double>>

    var numOfRows: Int = 0
    var numOfColumns: Int = 0

    constructor(width: Int, height: Int, sc: Scanner = Scanner(System.`in`)) {
        numOfRows = height
        numOfColumns = width
        matrix = List(numOfRows) { List(numOfColumns) { sc.nextDouble() } }
    }

    constructor(matrix: List<List<Double>>) {
        this.matrix = matrix
        numOfRows = matrix.size
        numOfColumns = matrix.first().size
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

    fun add(otherMatrix: Matrix): Matrix {
        return Matrix(buildList<List<Double>> {
            matrix.forEachIndexed { x, row ->
                add(buildList {
                    row.forEachIndexed { y, value -> add(value + otherMatrix.get(x, y)) }
                })
            }
        })
    }

    fun multiply(multiplier: Double): Matrix {
        return Matrix(buildList {
            matrix.forEach { row ->
                add(row.map { it * multiplier })
            }
        })
    }

    fun multiply(otherMatrix: Matrix): Matrix {
        val result = List(numOfRows) { MutableList(otherMatrix.numOfColumns) { 0.0 } }
        matrix.forEachIndexed { x, row ->
            otherMatrix.columns.forEachIndexed { y, column ->
                val sum = row.mapIndexed { index, value -> value * column[index] }.sum()
                result[x][y] = sum
            }
        }
        return Matrix(result)
    }

    fun getTranspose(transpose: Utils.Operation): Matrix {
        return when(transpose) {
            Utils.Operation.MAIN_DIAGONAL -> {
                Matrix(columns)
            }

            Utils.Operation.SIDE_DIAGONAL -> {
                Matrix(columns.reversed().map { it.reversed() })
            }

            Utils.Operation.HORIZONTAL_LINE -> {
                Matrix(matrix.reversed())
            }

            else -> {
                Matrix(matrix.map { it.reversed() })
            }
        }
    }

    fun calculateDeterminant(matrix: List<List<Double>> = this.matrix): Double {
        var determinant = 0.0
        if (matrix.size == 2) {
            val mainDiagonal: List<Double> = listOf(matrix.first().first(), matrix.last().last())
            val sideDiagonal: List<Double> = listOf(matrix.last().first(), matrix.first().last())
            return mainDiagonal.reduce { acc, d -> acc * d } - sideDiagonal.reduce { acc, d -> acc * d }
        } else {
            matrix.first().forEachIndexed { index, item ->
                val coFactor = getCofactor(index, matrix)
                val minor = calculateDeterminant(coFactor)
                if (index % 2 == 0)  {
                    determinant += item * minor
                } else {
                    determinant -= item * minor
                }
            }
            return determinant
        }
    }

    private fun getCofactor(index: Int, matrix: List<List<Double>> = this.matrix): List<List<Double>> {
        return buildList<List<Double>> {
            for (x in 1..matrix.lastIndex) {
                add(buildList {
                    matrix[x].indices.filter { it != index }.forEach { y ->
                        add(matrix[x][y])
                    }
                })
            }
        }
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
        ADD_MATRICES("Add matrices"), MULTIPLY_MATRIX_BY_CONSTANT("Multiply matrix by a constant"),
        MULTIPLY_MATRICES("Multiply matrices"), TRANSPOSE("Transpose matrix"),
        MAIN_DIAGONAL("Main diagonal"), SIDE_DIAGONAL("Side diagonal"),
        VERTICAL_LINE("Vertical line"), HORIZONTAL_LINE("Horizontal line"),
        CALCULATE_DETERMINANT("Calculate a determinant"), EXIT("Exit")
    }


    fun getMatrixFromInput(
        scanner: Scanner,
        getDetailsMessage: String? = null,
        getMatrixMessage: String? = null,
    ): Matrix {
        getDetailsMessage?.let { print(it) }
        val matrixHeight = scanner.nextInt()
        val matrixWidth = scanner.nextInt()
        getMatrixMessage?.let { println(it) }
        return Matrix(matrixWidth, matrixHeight)
    }
}
