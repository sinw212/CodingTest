package com.example.kotlincodingtest.programmers.running

import kotlin.math.*

fun main() {
    println(Solution최소직사각형().solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40)))) //4000
    println(Solution최소직사각형().solution(arrayOf(intArrayOf(10, 7), intArrayOf(12, 3), intArrayOf(8, 15), intArrayOf(14, 7), intArrayOf(5, 15)))) //120
    println(Solution최소직사각형().solution(arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11)))) //133
}

class Solution최소직사각형 {
    fun solution(sizes: Array<IntArray>): Int {
        var maxW = 0
        var maxH = 0
        sizes.forEach { size ->
           maxW = max(maxW, max(size[0], size[1]))
           maxH = max(maxH, min(size[0], size[1]))
        }
        return maxW * maxH
    }
}