package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    보물_1026().solution()
}

class 보물_1026 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine(), " ")
        val aArr = IntArray(n) { st.nextToken().toInt() }
        aArr.sort()
        st = StringTokenizer(readLine(), " ")
        val bArr = IntArray(n) { st.nextToken().toInt() }
        bArr.sortDescending()

        var sum = 0
        for(i in aArr.indices) {
            sum += aArr[i] * bArr[i]
        }
        println(sum)
    }
}