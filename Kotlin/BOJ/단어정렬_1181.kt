package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    단어정렬_1181().solution()
}

class 단어정렬_1181 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = Array(n) { readLine() }
        arr.sortWith(compareBy<String> { it.length}.thenBy { it })
        println(arr.distinct().joinToString("\n"))
    }
}