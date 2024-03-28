package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    파도반수열_9461().solution()
}

class 파도반수열_9461 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val dp = IntArray(101) {
            when(it) {
                in 1..3 -> 1
                in 4..5 -> 2
                else -> 0
            }
        }

        for(i in 6 .. 100) {
            dp[i] = dp[i-1] + dp[i-5]
        }

        val sb = StringBuilder()
        repeat(tc) {
            sb.append(dp[readLine().toInt()]).append("\n")
        }
        println(sb)
    }
}