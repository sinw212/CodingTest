package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    가장긴증가하는부분수열_11053().solution()
}

class 가장긴증가하는부분수열_11053 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = IntArray(n)
        val st = StringTokenizer(readLine(), " ")
        repeat(n) {
            arr[it] = st.nextToken().toInt()
        }
        val dp = IntArray(n) { 1 }
        for(i in 1 until n) {
            for(j in 0 until i) {
                if(arr[i] > arr[j]) {
                    dp[i] = maxOf(dp[i], dp[j]+1)
                }
            }
        }
        println(dp.maxOrNull())
    }
}