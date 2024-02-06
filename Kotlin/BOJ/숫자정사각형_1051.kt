package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val arr = Array(N) { readLine().toCharArray() }

    var answer = 1
    val std = if (N < M) N else M
    loop@ for (i in std downTo 1) {
        for (j in 0..N - i) {
            for (k in 0..M - i) {
                if (arr[j][k + (i - 1)] == arr[j][k]
                    && arr[j + (i - 1)][k] == arr[j][k]
                    && arr[j + (i - 1)][k + (i - 1)] == arr[j][k]
                ) {
                    answer = i
                    break@loop
                }
            }
        }
    }
    println(answer * answer)
}