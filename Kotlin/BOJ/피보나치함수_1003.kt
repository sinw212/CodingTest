package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    피보나치함수_1003().solution()
}

class 피보나치함수_1003 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val dp = Array(41) { 0 to 0 }
        dp[0] = 1 to 0
        dp[1] = 0 to 1
        for(i in 2 .. 40) {
            dp[i] = (dp[i-1].first + dp[i-2].first) to (dp[i-1].second + dp[i-2].second)
        }
        repeat(tc) {
            val num = readLine().toInt()
            println("${dp[num].first} ${dp[num].second}")
        }
    }
}