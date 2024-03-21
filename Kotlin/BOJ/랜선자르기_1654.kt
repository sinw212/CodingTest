package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    랜선자르기_1654().solution()
}

class 랜선자르기_1654 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (k, n) = readLine().split(" ").map { it.toInt() }
        val arr = IntArray(k)
        repeat(k) {
            arr[it] = readLine().toInt()
        }
        arr.sortDescending()
        println(searchBinary(arr, n))
    }

    fun searchBinary(arr: IntArray, n: Int): Long {
        var left = 1L
        var right = arr[0].toLong()
        while(left <= right) {
            val mid = (left + right) / 2
            var count = 0L
            arr.forEach {
                count += (it / mid)
            }
            when {
                count < n -> right = mid - 1
                count >= n -> left = mid + 1
            }
        }
        return right
    }
}