package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    이xn타일링2_11727().solution()
}

class 이xn타일링2_11727 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = IntArray(num+1) {
            when(it) {
                1 -> 1
                2 -> 3
                else -> 0
            }
        }

        for(i in 3 .. num) {
            dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007
        }
        println(dp[num])
    }
}