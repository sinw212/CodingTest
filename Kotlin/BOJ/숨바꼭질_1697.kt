package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    if(n >= k) {
        println(n - k)
    } else {
        println(bfs_1697(n, k))
    }
}

fun bfs_1697(n: Int, k: Int): Int {
    val queue: Queue<Move> = LinkedList()
    val visited = BooleanArray(100001)
    queue.add(Move(n, 0))
    visited[n] = true

    while(queue.isNotEmpty()) {
        val (point, count) = queue.poll()
        if(point == k) {
            return count
        }
        if(point + 1 in 0 .. 100000 && !visited[point + 1]) {
            queue.add(Move(point + 1, count + 1))
            visited[point + 1] = true
        }
        if(point - 1 in 0 .. 100000 && !visited[point - 1]) {
            queue.add(Move(point - 1, count + 1))
            visited[point - 1] = true
        }
        if(point * 2 in 0 .. 100000 && !visited[point * 2]) {
            queue.add(Move(point * 2, count + 1))
            visited[point * 2] = true
        }
    }
    return -1
}

data class Move(val point: Int, val count: Int)