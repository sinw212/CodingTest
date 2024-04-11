package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    요세푸스문제_1158_3().solution()
}

class 요세푸스문제_1158_3 {
    fun solution() {
        val (n, k) = BufferedReader(InputStreamReader(System.`in`)).readLine().split(" ").map { it.toInt() }
        val queue = LinkedList<Int>()
        for(i in 1 .. n) {
            queue.add(i)
        }

        val answer = IntArray(n)
        for(i in 0 until n) {
            repeat(k-1) {
                queue.add(queue.poll())
            }
            answer[i] = queue.poll()
        }
        println("<${answer.joinToString(", ")}>")
    }
}