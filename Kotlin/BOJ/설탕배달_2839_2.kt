package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    설탕배달_2839_2().solution()
}

class 설탕배달_2839_2 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var minValue = Integer.MAX_VALUE
        var count = 0
        for(i in n / 5 downTo 1) {
            count = i
            count += (n - 5 * i) / 3
            if((n - 5 * i) % 3 == 0) {
                minValue = minOf(minValue, count)
            }
        }
        if(n % 3 == 0) {
            minValue = minOf(minValue, n / 3)
        }

        println(if(minValue == Integer.MAX_VALUE) -1 else minValue)
    }
}