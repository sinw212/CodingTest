package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    예산_2512().solution()
}

class 예산_2512 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine(), " ")
        val costs = IntArray(n) { st.nextToken().toInt() }
        val maxCost = readLine().toInt()
        costs.sort()

        var sum = 0
        costs.forEach { cost ->
            sum += cost
        }
        if(sum <= maxCost) {
            println(costs[n-1])
        } else {
            var left = 1
            var right = costs[n-1]
            while(left <= right) {
                val mid = (left + right) / 2
                sum = 0
                costs.forEach { cost ->
                    sum += if(cost < mid) cost else mid
                }
                when {
                    sum <= maxCost -> left = mid+1
                    sum > maxCost -> right = mid-1
                }
            }
            println(right)
        }
    }
}