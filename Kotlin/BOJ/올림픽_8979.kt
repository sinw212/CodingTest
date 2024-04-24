package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    올림픽_8979().solution()
}

class 올림픽_8979 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val arr = Array(n) { 0 to Medal(0, 0, 0) }
        repeat(n) { i ->
            val (num, gold, silver, bronze) = readLine().split(" ").map { it.toInt() }
            arr[i] = Pair(num, Medal(gold, silver, bronze))
        }
        val sortedArr = arr.sortedWith(
            compareByDescending<Pair<Int, Medal>> { it.second.g }.thenByDescending { it.second.s }.thenByDescending { it.second.b }
        )

        val rank = hashMapOf<Int, Int>()
        rank[sortedArr[0].first] = 1
        if(sortedArr[0].first != k) {
            for(i in 1 until n) {
                rank[sortedArr[i].first] = if(!check(sortedArr[i].second, sortedArr[i-1].second)) {
                     i+1
                } else {
                    rank.getOrDefault(sortedArr[i-1].first, 0)
                }
                if(sortedArr[i].first == k) {
                    break
                }
            }
        }
        println(rank[k])
    }

    fun check(first: Medal, second: Medal): Boolean
        = first.g == second.g && first.s == second.s && first.b == second.b
}

data class Medal(val g: Int, val s: Int, val b: Int)