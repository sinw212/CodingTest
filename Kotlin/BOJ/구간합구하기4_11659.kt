package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    구간합구하기4_11659().solution()
}

class 구간합구하기4_11659 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val st = StringTokenizer(readLine(), " ")
        val nums = IntArray(n+1) {
            when(it) {
                0 -> 0
                else -> st.nextToken().toInt()
            }
        }

        val dp = IntArray(n+1)
        for(i in 1 .. n) {
            dp[i] = dp[i-1] + nums[i]
        }

        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(m) {
            val (start, end) = readLine().split(" ").map { it.toInt() }
            bw.write("${dp[end] - dp[start-1]}\n")
        }
        bw.flush()
        bw.close()
    }
}