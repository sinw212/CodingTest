package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    일로만들기_1463().solution()
}

class 일로만들기_1463 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = IntArray(num+1)
        for (i in 2..num) {
            dp[i] = dp[i - 1] + 1
            if (i % 2 == 0) dp[i] = minOf(dp[i], dp[i / 2] + 1)
            if (i % 3 == 0) dp[i] = minOf(dp[i], dp[i / 3] + 1)
        }
        println(dp[num])
    }
}