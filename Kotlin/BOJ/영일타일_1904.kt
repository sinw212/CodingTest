package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    영일타일_1904().solution()
}

class 영일타일_1904 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = IntArray(num+1) {
            when(it) {
                1 -> 1
                2 -> 2
                else -> 0
            }
        }
        for(i in 3 .. num) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746
        }
        println(dp[num])
    }
}