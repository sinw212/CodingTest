package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    주유소_13305().solution()
}

class 주유소_13305 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine(), " ")
        val distance = LongArray(n-1) { st.nextToken().toLong() }
        st = StringTokenizer(readLine(), " ")
        val cost = LongArray(n) { st.nextToken().toLong() }

        var answer = 0L
        var current = cost[0]
        answer += cost[0] * distance[0]
        for(i in 1 until n-1) {
            if(cost[i] < current) {
                current = cost[i]
            }
            answer += current * distance[i]
        }
        println(answer)
    }
}