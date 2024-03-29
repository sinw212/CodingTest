package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    퇴사_14501().solution()
}

class 퇴사_14501 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val schedules = Array(n+1) { Schedule(0, 0) }
        repeat(n) { arr ->
            val (time, pay) = readLine().split(" ").map { it.toInt() }
            schedules[arr + 1] = Schedule(time, pay)
        }
        val dp = IntArray(n+1)
        for(i in 1 .. n) {
            if(n+1 - i >= schedules[i].time) {
                dp[i] = schedules[i].pay
            }
            for(j in 1 until i) {
                if(i - j >= schedules[j].time) {
                    dp[i] = maxOf(dp[i], dp[j] + if(n+1 - i >= schedules[i].time) schedules[i].pay else 0)
                }
            }
        }
        println(dp.maxOrNull())
    }
}

data class Schedule(val time: Int, val pay: Int)