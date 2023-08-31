package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val num = readLine().toInt()
    val splitArr = readLine().split(" ")
    val deque = ArrayDeque((1..num).map { it to splitArr[it-1].toInt() })

    for(i in 1 until num) {
        val answer = deque.removeFirst()
        sb.append("${answer.first} ")
        val move = answer.second
        if(move > 0) {
            for(i in 1 until move) {
                deque.addLast(deque.removeFirst())
            }
        } else {
            for(i in move until 0) {
                deque.addFirst(deque.removeLast())
            }
        }
    }
    sb.append("${deque.removeLast().first}")
    println(sb.toString())
    close()
}