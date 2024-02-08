package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    val hashMap = hashMapOf<String, Int>()
    repeat(num) {
        val s = readLine()
        hashMap[s] = hashMap.getOrDefault(s, 1) + 1
    }

    val maxValue = hashMap.values.maxOrNull()
    println(hashMap.filter { it.value == maxValue }.keys.minOf { it })
}