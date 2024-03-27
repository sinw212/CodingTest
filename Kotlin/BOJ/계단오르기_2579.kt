package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    계단오르기_2579().solution()
}

class 계단오르기_2579 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val num = readLine().toInt()
        val stairs = IntArray(num+1)
        repeat(num) {
            stairs[it+1] = readLine().toInt()
        }

        val dp = IntArray(num+1) {
            when(it) {
                1 -> stairs[1]
                2 -> stairs[1] + stairs[2]
                else -> 0
            }
        }
        for(i in 3 .. num) {
            dp[i] = stairs[i] + maxOf(dp[i-2], dp[i-3] + stairs[i-1])
        }
        println(dp[num])
    }
}