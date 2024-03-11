package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    repeat(n) {
        val num = readLine().toInt()
        println(makeNum(num, 0, 0))
    }
}

fun makeNum(num: Int, sum: Int, count: Int): Int {
    var answer = count
    if(sum >= num) {
        if(sum == num) answer++
        return answer
    }
    for(i in 1 .. 3) {
        answer = makeNum(num, sum + i, answer)
    }
    return answer
}