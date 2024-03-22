package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    설탕배달_2839().solution()
}

class 설탕배달_2839 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val dp = IntArray(n+1) { 9999 }
        dp[0] = 0
        dp[3] = 1

        for(i in 5 .. n) {
            dp[i] = minOf(dp[i-3] + 1, dp[i-5] + 1)
        }
        println(if(dp[n] >= 9999) -1 else dp[n])
    }
}