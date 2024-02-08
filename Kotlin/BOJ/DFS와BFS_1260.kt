package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

var graph: Array<IntArray> = arrayOf()
var visited: BooleanArray = booleanArrayOf()
var result = mutableListOf<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, V) = readLine().split(" ").map { it.toInt() }
    graph = Array(N+1) { IntArray(N+1) }
    visited = BooleanArray(N+1) { false }

    repeat(M) {
        val (num1, num2) = readLine().split(" ").map { it.toInt() }
        graph[num1][num2] = 1
        graph[num2][num1] = 1
    }

    println(dfs(V, N).joinToString(" "))
    result.clear()
    visited = BooleanArray(N+1) { false }
    println(bfs(V, N).joinToString(" "))
}

fun dfs(start: Int, N: Int): List<Int> {
    result.add(start)
    visited[start] = true

    for(i in 1 .. N) {
        if(graph[start][i] != 0 && !visited[i]) {
            dfs(i, N)
        }
    }
    return result
}

fun bfs(node: Int, N: Int): List<Int> {
    visited[node] = true

    val queue = LinkedList<Int>()
    queue.add(node)
    while(queue.isNotEmpty()) {
        val current = queue.poll()
        result.add(current)
        for(i in 1 .. N) {
            if(graph[current][i] != 0 && !visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
    return result
}