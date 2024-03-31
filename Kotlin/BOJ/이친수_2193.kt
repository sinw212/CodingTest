package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    이친수_2193().solution()
}

class 이친수_2193 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = LongArray(num+1)
        dp[1] = 1
        for(i in 2 .. num) {
            dp[i] = dp[i-1] + dp[i-2]
        }
        println(dp[num])
    }
}