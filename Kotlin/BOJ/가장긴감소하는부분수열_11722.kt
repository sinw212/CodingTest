package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    가장긴감소하는부분수열_11722().solution()
}

class 가장긴감소하는부분수열_11722 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine(), " ")
        val arr = IntArray(n) { st.nextToken().toInt() }
        val dp = IntArray(n) {
            when(it) {
                0 -> 1
                else -> 0
            }
        }

        for(i in 1 until n) {
            for(j in 0 until i) {
                dp[i] = when {
                    arr[i] > arr[j] -> maxOf(dp[i], 1)
                    arr[i] < arr[j] -> maxOf(dp[i], dp[j]+1)
                    else -> dp[j]
                }
            }
        }
        println(dp.maxOrNull())
    }
}