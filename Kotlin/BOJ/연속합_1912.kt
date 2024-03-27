package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    연속합_1912().solution()
}

class 연속합_1912 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
        val dp = IntArray(tc)
        dp[0] = nums[0]
        for(i in 1 until tc) {
            dp[i] = maxOf(dp[i-1]+nums[i], nums[i])
        }
        println(dp.maxOrNull())
    }
}