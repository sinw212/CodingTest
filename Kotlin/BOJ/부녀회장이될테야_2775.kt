package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    부녀회장이될테야_2775().solution()
}

class 부녀회장이될테야_2775 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val dp = Array(15) { IntArray(15) }
        for(i in 1 until 15) {
            dp[0][i] = i
        }
        for(i in 1 until 15) {
            for(j in 1 until 15) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
            }
        }

        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(tc) {
            val n = readLine().toInt()
            val k = readLine().toInt()
            bw.write("${dp[n][k]}\n")
        }

        bw.flush()
        bw.close()
    }
}