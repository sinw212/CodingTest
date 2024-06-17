package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(ShapeArea().solution(2)) //5
    println(ShapeArea().solution(3)) //13
}
class ShapeArea {
    fun solution(n: Int): Int {
        val dp = IntArray(n+1)
        dp[1] = 1
        for(i in 2 until dp.size) {
            dp[i] = dp[i-1] + (4 * (i-1))
        }
        return dp[n]
    }
}