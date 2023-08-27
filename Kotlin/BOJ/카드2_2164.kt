package com.example.kotlincodingtest.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val num = readLine().toInt()
    val queue: Queue<Int> = LinkedList()
    for(n in 1 .. num) {
        queue.add(n)
    }
    while(queue.size > 1) {
        queue.poll()
        queue.add(queue.poll())
    }
    println(queue.poll())
    close()
}