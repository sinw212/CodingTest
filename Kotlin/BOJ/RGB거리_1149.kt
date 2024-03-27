package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    RGB거리_1149().solution()
}

class RGB거리_1149 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val dp = Array(tc) { IntArray(3) }
        val rgb = Array(tc) { IntArray(3) }
        repeat(tc) { case ->
            rgb[case] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        dp[0][0] = rgb[0][0]
        dp[0][1] = rgb[0][1]
        dp[0][2] = rgb[0][2]

        for(i in 1 until tc) {
            //dp[i][j] = i번째 집에 j색으로 칠할 때의 최소비용
            dp[i][0] = rgb[i][0] + minOf(dp[i-1][1], dp[i-1][2])
            dp[i][1] = rgb[i][1] + minOf(dp[i-1][0], dp[i-1][2])
            dp[i][2] = rgb[i][2] + minOf(dp[i-1][0], dp[i-1][1])
        }
        println(minOf(dp[tc-1][0], dp[tc-1][1], dp[tc-1][2]))
    }
}