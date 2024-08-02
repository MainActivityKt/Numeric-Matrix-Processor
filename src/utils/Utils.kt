package utils

import java.util.Scanner

object Utils {
    fun getMatrixFromInput(sc: Scanner): List<MutableList<Int>> {
        val height = sc.nextInt()
        val width = sc.nextInt()
        val matrix = MutableList(height) { MutableList(width) { 0 } }
        for (y in 0..<height) {
            for (x in 0..<width) {
                matrix[y][x] = sc.nextInt()
            }
        }
        return matrix
    }

    fun List<List<Int>>.printMatrix()  = this.forEach { println(it.joinToString(" ")) }
}
