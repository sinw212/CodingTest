package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    포도주시식_2156().solution()
}

class 포도주시식_2156 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val wine = IntArray(tc + 1)
        repeat(tc) {
            wine[it + 1] = readLine().toInt()
        }

        val dp = IntArray(tc + 1) {
            when(it) {
                1 -> wine[1]
                2 -> wine[1] + wine[2]
                else -> 0
            }
        }
        for(i in 3 .. tc) {
            dp[i] = maxOf(dp[i-1], wine[i]+dp[i-2], wine[i]+wine[i-1]+dp[i-3])
        }
        println(dp[tc])
    }
}