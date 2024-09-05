package matrixprocessor

import utils.Utils.Operation.*
import utils.Utils.getMatrixFromInput
import java.util.Scanner

class DeterminantCalculator: TransposeCalculator() {
    private val sc = Scanner(System.`in`)

    override val menuItems = mapOf(
        ADD_MATRICES to 1,
        MULTIPLY_MATRIX_BY_CONSTANT to 2,
        MULTIPLY_MATRICES to 3,
        TRANSPOSE to 4,
        CALCULATE_DETERMINANT to 5,
        EXIT to 0,
    )

    override fun performCalculation() {
        printMenu()
        val input = getInput().toInt()
        when(input) {
            menuItems[ADD_MATRICES] -> addMatrices()
            menuItems[MULTIPLY_MATRICES] -> multiply()
            menuItems[MULTIPLY_MATRIX_BY_CONSTANT] -> multiply(byConstant = true)
            menuItems[TRANSPOSE] -> transpose()
            menuItems[CALCULATE_DETERMINANT] -> calculateDeterminant()
        }
        println()
        if (input != menuItems[EXIT]) {
            performCalculation()
        }
    }

    private fun calculateDeterminant() {
        val matrix = getMatrixFromInput(sc, "Enter matrix size: ", "Enter matrix: ")
        val result = matrix.calculateDeterminant()
        printResult(result)
    }
}

fun main() {
    DeterminantCalculator().performCalculation()
}