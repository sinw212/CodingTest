package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    동전0_11047().solution()
}

class 동전0_11047 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val coins = IntArray(n)
        repeat(n) {
            coins[it] = readLine().toInt()
        }
        coins.sortDescending()
        var num = k
        var count = 0
        for(i in coins.indices) {
            if(num / coins[i] >= 1) {
                count += num / coins[i]
                num %= coins[i]
            }
        }
        println(count)
    }
}