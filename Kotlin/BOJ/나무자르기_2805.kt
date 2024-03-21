package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    나무자르기_2805().solution()
}

class 나무자르기_2805 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m) = readLine().split(" ").map { it.toLong() }
        val st = StringTokenizer(readLine(), " ")
        val arr = LongArray(n.toInt()) { st.nextToken().toLong() }
        arr.sortDescending()
        println(binarySearch(arr, m))
    }

    fun binarySearch(arr: LongArray, m: Long): Long {
        var left = 1L
        var right = arr[0]
        while(left <= right) {
            val mid = (left + right) / 2
            var count = 0L
            arr.forEach {
                count += if(it > mid) it-mid else 0
            }
            when {
                count < m -> right = mid - 1
                count >= m -> left = mid + 1
            }
        }
        return right
    }
}