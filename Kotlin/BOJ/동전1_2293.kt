package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    동전1_2293().solution()
}

class 동전1_2293 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val coins = IntArray(n)
        repeat(n) {
            coins[it] = readLine().toInt()
        }

        val dp = IntArray(k + 1)
        dp[0] = 1
        for(coin in coins) {
            for(j in coin .. k) {
                dp[j] += dp[j - coin]
            }
        }
        println(dp[k])
    }
}