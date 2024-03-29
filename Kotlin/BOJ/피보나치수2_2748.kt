package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    피보나치수2_2748().solution()
}

class 피보나치수2_2748 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = LongArray(num + 1) {
            when(it) {
                1 -> 1
                else -> 0
            }
        }
        for(i in 2 .. num) {
            dp[i] = dp[i-1] + dp[i-2]
        }
        println(dp[num])
    }
}