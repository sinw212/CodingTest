package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    스티커_9465().solution()
}

class 스티커_9465 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(tc) {
            val n = readLine().toInt()
            val stickers = Array(2) { IntArray(n) }
            repeat(2) { s ->
                stickers[s] = readLine().split(" ").map { it.toInt() }.toIntArray()
            }
            val dp = Array(2) { IntArray(n+1) }
            dp[0][1] = stickers[0][0]
            dp[1][1] = stickers[1][0]
            for(i in 2 .. n) {
                dp[0][i] = maxOf(dp[1][i-1], dp[1][i-2]) + stickers[0][i-1]
                dp[1][i] = maxOf(dp[0][i-1], dp[0][i-2]) + stickers[1][i-1]
            }
            println(dp.joinToString(", ") { it.joinToString(" ")})
            bw.write("${maxOf(dp[0][n], dp[1][n])}\n")
        }
        bw.flush()
        bw.close()
    }
}