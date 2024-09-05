package matrixprocessor

import utils.Utils.Operation.*
import utils.Utils.getMatrixFromInput
import java.util.Scanner

class TransposeCalculator: MatricesCalculator() {
    private val sc = Scanner(System.`in`)

    override val menuItems = mapOf(
        ADD_MATRICES to 1,
        MULTIPLY_MATRIX_BY_CONSTANT to 2,
        MULTIPLY_MATRICES to 3,
        TRANSPOSE to 4,
        EXIT to 0,
    )

    private val transposeOptions = mapOf(
        MAIN_DIAGONAL to 1,
        SIDE_DIAGONAL to 2,
        VERTICAL_LINE to 3,
        HORIZONTAL_LINE to 4
    )

    override fun performCalculation() {
        printMenu()
        val input = getInput().toInt()
        when(input) {
            menuItems[ADD_MATRICES] -> addMatrices()
            menuItems[MULTIPLY_MATRICES] -> multiply()
            menuItems[MULTIPLY_MATRIX_BY_CONSTANT] -> multiply(byConstant = true)
            menuItems[TRANSPOSE] -> transpose()
        }
        println()
        if (input != menuItems[EXIT]) {
            performCalculation()
        }
    }

    private fun transpose() {
        printMenu(transposeOptions)
        val input = getInput().toInt()
        val matrix = getMatrixFromInput(sc, "Enter matrix size: ", "Enter matrix: ")
        val result = when(input) {
            transposeOptions[MAIN_DIAGONAL] -> matrix.getTranspose(MAIN_DIAGONAL)
            transposeOptions[SIDE_DIAGONAL] -> matrix.getTranspose(SIDE_DIAGONAL)
            transposeOptions[HORIZONTAL_LINE] -> matrix.getTranspose(HORIZONTAL_LINE)
            transposeOptions[VERTICAL_LINE] -> matrix.getTranspose(VERTICAL_LINE)
           else -> matrix
        }
        printResult(result)
    }
}

fun main() {
    TransposeCalculator().performCalculation()
}