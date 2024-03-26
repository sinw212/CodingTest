package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    이xn타일링_11726().solution()
}

class 이xn타일링_11726 {
    fun solution() {
        val num = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val dp = IntArray(num + 1)
        dp[0] = 1
        dp[1] = 1
        if(num >= 2) {
            for(i in 2 .. num) {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007
            }
        }
        println(dp[num])
    }
}