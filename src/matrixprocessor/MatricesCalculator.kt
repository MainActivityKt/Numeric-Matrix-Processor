package matrixprocessor

import utils.Matrix
import utils.Utils.Operation
import utils.Utils.Operation.*
import utils.Utils.getMatrixFromInput
import java.util.Scanner

open class MatricesCalculator {
    private val sc = Scanner(System.`in`)


    open val menuItems = mapOf(
        Operation.ADD_MATRICES to 1,
        Operation.MULTIPLY_MATRIX_BY_CONSTANT to 2,
        Operation.MULTIPLY_MATRICES to 3,
        Operation.EXIT to 0,
    )

    open fun performCalculation() {
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

    protected fun addMatrices() {
        val matrix = getMatrixFromInput(
            sc, "Enter size of first matrix: ","Enter first matrix:"
        )
        val additionMatrix = getMatrixFromInput(
            sc, "Enter size of second matrix: ", "Enter second matrix:"
        )
        if (matrix.numOfRows == additionMatrix.numOfRows && matrix.numOfColumns == additionMatrix.numOfColumns) {
            val result = matrix.add(additionMatrix)
            printResult(result)
        } else {
            println("The operation cannot be performed.")
        }
    }

    protected fun multiply(byConstant: Boolean = false) {
        val result: Matrix
        if (byConstant) {
            val matrix = getMatrixFromInput(sc, "Enter size of matrix:", "Enter matrix:")
            val multiplier = getInput("Enter constant: ")
            result = matrix.multiply(multiplier)

        } else {
            val matrix = getMatrixFromInput(
                sc, "Enter size of first matrix: ","Enter first matrix:"
            )
            val multiplierMatrix = getMatrixFromInput(
                sc, "Enter size of second matrix: ", "Enter second matrix:"
            )
            result = matrix.multiply(multiplierMatrix)
        }
        printResult(result)
    }

    protected fun printMenu(menu: Map<Operation, Int> = menuItems) {
        menu.forEach { (k, v) -> println("$v. ${k.value}") }
    }

    protected fun printResult(matrix: Matrix) {
        println("The result is:")
        print(matrix)
    }

    protected fun getInput(message: String = "Your choice: "): Double {
        print(message)
        return sc.nextDouble()
    }
}

fun main() {
    MatricesCalculator().performCalculation()
}