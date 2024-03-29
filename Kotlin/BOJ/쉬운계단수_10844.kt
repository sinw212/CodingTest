package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    쉬운계단수_10844().solution()
}

class 쉬운계단수_10844 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = Array(num + 1) { IntArray(10) }
        for(i in 1 .. 9) {
            dp[1][i] = 1
        }
        for(i in 2 .. num) {
            for(j in 0 .. 9) {
                dp[i][j] = (when(j) {
                    0 -> dp[i-1][1]
                    9 -> dp[i-1][8]
                    else -> dp[i-1][j-1] + dp[i-1][j+1]
                }) % 1000000000
            }
        }

        var sum = 0L
        dp[num].forEach { sum += it }
        println(sum % 1000000000)
    }
}