package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    부분수열의합_1182().solution()
}

class 부분수열의합_1182 {
    var count = 0
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, s) = readLine().split(" ").map { it.toInt() }
        val st = StringTokenizer(readLine(), " ")
        val arr = IntArray(n) { st.nextToken().toInt() }

        for(i in arr.indices) {
            dfs(n, s, 1, i, arr[i], arr)
        }
        println(count)
    }

    fun dfs(n: Int, s: Int, depth: Int, idx: Int, sum: Int, arr: IntArray) {
        if(sum == s) {
            count++
        }
        if(depth == n) {
            return
        }
        for(i in idx+1 until arr.size) {
            dfs(n, s, depth+1, i, sum+arr[i], arr)
        }
    }
}