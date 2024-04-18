package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    카드구매하기_11052().solution()
}

class 카드구매하기_11052 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine(), " ")
        val cards = IntArray(n + 1) {
            when(it) {
                0 -> 0
                else -> st.nextToken().toInt()
            }
        }

        val dp = IntArray(n + 1)
        dp[1] = cards[1]
        for(i in 2 .. n) {
            dp[i] = cards[i]
            for(j in 0 .. i/2) {
                dp[i] = maxOf(dp[i], dp[i-j] + cards[j])
            }
        }
        println(dp[n])
    }
}