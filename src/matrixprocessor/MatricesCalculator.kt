package matrixprocessor

import utils.Matrix
import utils.Utils.menuItems
import utils.Utils.Operation.*
import utils.Utils.getMatrixFromInput
import java.util.Scanner

class MatricesCalculator {
    private val sc = Scanner(System.`in`)
    fun performCalculation() {
        printMenu()
        val input = getInput().toInt()
        when(input) {
            menuItems[ADD_MATRICES] -> addMatrices()
            menuItems[MULTIPLY_MATRICES] -> multiply()
            menuItems[MULTIPLY_MATRIX_BY_CONSTANT] -> multiply(byConstant = true)
        }
        println()
       if (input != menuItems[EXIT]) {
           performCalculation()
       }
    }

    private fun addMatrices() {
        val matrix = getMatrixFromInput(
            sc, "Enter size of first matrix: ","Enter first matrix:"
        )
        val additionMatrix = getMatrixFromInput(
            sc, "Enter size of second matrix: ", "Enter second matrix:"
        )
        if (matrix.numOfRows == additionMatrix.numOfRows && matrix.numOfColumns == additionMatrix.numOfColumns) {
            matrix.add(additionMatrix)
            printResult(matrix)
        } else {
            println("The operation cannot be performed.")
        }
    }

    private fun multiply(byConstant: Boolean = false) {
        if (byConstant) {
            val matrix = getMatrixFromInput(sc, "Enter size of matrix:", "Enter matrix:")
            val multiplier = getInput("Enter constant: ")
            matrix.multiply(multiplier)
            printResult(matrix)

        } else {
            val matrix = getMatrixFromInput(
                sc, "Enter size of first matrix: ","Enter first matrix:"
            )
            val multiplyMatrix = getMatrixFromInput(
                sc, "Enter size of second matrix: ", "Enter second matrix:"
            )
            matrix.multiply(multiplyMatrix)
            printResult(matrix)
        }
    }

    private fun printMenu() {
        menuItems.forEach { (k, v) -> println("$v. ${k.value}") }
    }

    private fun printResult(matrix: Matrix) {
        println("The result is:")
        println(matrix)
    }

    private fun getInput(message: String = "Your choice: "): Double {
        print(message)
        return sc.nextDouble()
    }
}

fun main() {
    MatricesCalculator().performCalculation()
}