package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    카드정렬하기_1715().solution()
}

class 카드정렬하기_1715 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        if(n == 1) {
            readLine().toInt()
            println(0)
        } else {
            val pq = PriorityQueue<Int>()
            repeat(n) {
                pq.add(readLine().toInt())
            }
            var sum = 0
            while(pq.size > 2) {
                val sumNum = pq.poll() + pq.poll()
                sum += sumNum
                pq.add(sumNum)
            }
            sum += pq.poll() + pq.poll()
            println(sum)
        }
    }
}