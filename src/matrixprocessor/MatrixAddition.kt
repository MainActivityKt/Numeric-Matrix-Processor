package matrixprocessor

import utils.Matrix
import utils.Utils.getMatrixFromInput
import java.util.Scanner

class MatrixAddition {
    private val sc = Scanner(System.`in`)
    private lateinit var originalMatrix: Matrix
    private lateinit var additionMatrix: Matrix

    fun initializeMatrices() {
        originalMatrix = getMatrixFromInput(sc)
        this.additionMatrix = getMatrixFromInput(sc)
    }

    fun performAddition() {
        if (originalMatrix.numOfColumns == this.additionMatrix.numOfColumns && originalMatrix.numOfRows == this.additionMatrix.numOfRows) {
            originalMatrix.add(this.additionMatrix)
            println(originalMatrix)
        } else {
            println("Error")
        }
    }
}


fun main() {
    val addition = MatrixAddition()
    addition.initializeMatrices()
    addition.performAddition()
}