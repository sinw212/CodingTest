package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(MatrixElementsSum().solution(
        mutableListOf(mutableListOf(0,1,1,2), mutableListOf(0,5,0,0), mutableListOf(2,0,3,3))
    )) //9
    println(MatrixElementsSum().solution(
        mutableListOf(mutableListOf(1,1,1,0), mutableListOf(0,5,0,1), mutableListOf(2,1,3,10))
    )) //9
}
class MatrixElementsSum {
    fun solution(matrix: MutableList<MutableList<Int>>): Int {
        var sum = 0
        for(i in matrix[0].indices) {
            if(matrix[0][i] != 0) {
                for(j in matrix.indices) {
                    if(matrix[j][i] == 0) {
                        break
                    }
                    sum += matrix[j][i]
                }
            }
        }
        return sum
    }
}