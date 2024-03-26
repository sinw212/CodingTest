package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    일이삼더하기_9095_2().solution()
}

class 일이삼더하기_9095_2 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val dp = IntArray(12)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for(i in 4 .. 11) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
        }
        repeat(tc) {
            val num = readLine().toInt()
            bw.write("${dp[num]}\n")
        }
        bw.flush()
        bw.close()
    }
}