package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    평범한배낭_12865().solution()
}

class 평범한배낭_12865 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val products = Array(n + 1) { Product(0, 0) }
        repeat(n) { prod ->
            val (weight, value) = readLine().split(" ").map { it.toInt() }
            products[prod + 1] = Product(weight, value)
        }

        val dp = Array(n+1) { IntArray(k+1) }
        for(i in 1 .. n) {
            for(j in 1 .. k) {
                dp[i][j] = if(products[i].weight > j) {
                    dp[i-1][j]
                } else {
                    maxOf(dp[i-1][j], products[i].value + dp[i-1][j-products[i].weight])
                }
            }
        }
        println(dp[n][k])
    }
}

data class Product(val weight: Int, val value: Int)