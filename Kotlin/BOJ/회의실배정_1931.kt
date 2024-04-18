package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    회의실배정_1931().solution()
}

class 회의실배정_1931 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val conferences = Array(n) { Conf(0, 0) }

        repeat(n) {
            val (start, end) = readLine().split(" ").map { it.toInt() }
            conferences[it] = Conf(start, end)
        }
        conferences.sortWith(compareBy<Conf> { it.end }.thenBy { it.start })

        var sum = 1
        var current = conferences[0]
        for(i in 1 until conferences.size) {
            if(current.end <= conferences[i].start) {
                current = conferences[i]
                sum += 1
            }
        }
        println(sum)

        /*
        //DP로 풀면 시간초과 발생 - 그리디 알고리즘으로 수정
        conferences.sortBy { it.start }

        val dp = IntArray(n) { 1 }
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (conferences[j].end <= conferences[i].start) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }
        println(dp[n - 1])
         */
    }
}

data class Conf(val start: Int, val end: Int)