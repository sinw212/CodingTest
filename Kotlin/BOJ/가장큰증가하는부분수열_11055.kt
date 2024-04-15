package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    가장큰증가하는부분수열_11055().solution()
}

class 가장큰증가하는부분수열_11055 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine(), " ")
        val arr = IntArray(n) { st.nextToken().toInt() }
        val dp = IntArray(n)
        dp[0] = arr[0]
        for(i in 1 until n) {
            dp[i] = arr[i]
            for(j in 0 until i) {
                if(arr[i] > arr[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + arr[i])
                }
            }
        }
        println(dp.maxOrNull())
    }
}