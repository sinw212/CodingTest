package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    가로수_2485().solution()
}

class 가로수_2485 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val trees = IntArray(n) { readLine().toInt() }
        val diff = IntArray(n-1)
        for(i in diff.indices) {
            diff[i] = trees[i+1] - trees[i]
        }

        var gcdValue = diff[0]
        for(i in 1 until diff.size) {
            gcdValue = gcd(gcdValue, diff[i])
        }
        var sum = 0
        for(d in diff) {
            sum += (d / gcdValue) - 1
        }
        println(sum)
    }

    fun gcd(a: Int, b: Int): Int = if(b != 0) gcd(b, a%b) else a
}