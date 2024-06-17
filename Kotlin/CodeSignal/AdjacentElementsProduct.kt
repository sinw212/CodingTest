package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(AdjacentElementsProduct().solution(mutableListOf(3, 6, -2, -5, 7, 3))) //21
}
class AdjacentElementsProduct {
    fun solution(inputArray: MutableList<Int>): Int {
        var maxNum = Integer.MIN_VALUE
        for(i in 0 until inputArray.size - 1) {
            maxNum = maxOf(maxNum, inputArray[i] * inputArray[i+1])
        }
        return maxNum
    }
}