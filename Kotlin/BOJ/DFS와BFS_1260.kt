package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

var graph: Array<IntArray> = arrayOf()
var visited: BooleanArray = booleanArrayOf()
var result = mutableListOf<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, V) = readLine().split(" ").map { it.toInt() }
    graph = Array(N) { IntArray(N) }
    visited = BooleanArray(N) { false }
    repeat(M) {
        val (num1, num2) = readLine().split(" ").map { it.toInt() }
        graph[num1 - 1][num2 - 1] = 1
        graph[num2 - 1][num1 - 1] = 1
    }

    val dfsResult = dfs(V - 1, N)
    println(dfsResult.joinToString(" "))

    result.clear()
    visited = BooleanArray(N) { false }
    val bfsResult = bfs(V - 1, N)
    println(bfsResult.joinToString(" "))
}

fun dfs(v: Int, N: Int): List<Int> {
    result.add(v+1)
    visited[v] = true

    for(i in 0 until N) {
        if(graph[v][i] != 0 && !visited[i]) {
            dfs(i, N)
        }
    }
    return result
}

fun bfs(v: Int, N: Int): List<Int> {
    visited[v]=true
    result.add(v+1)

    val queue : Queue<Int> = LinkedList()
    queue.add(v)
    while (!queue.isEmpty()) {
        val current = queue.poll()
        for (i in 0 until N) {
            if (graph[current][i] != 0 && !visited[i]) {
                queue.add(i)
                visited[i] = true
                result.add(i + 1)
            }
        }
    }
    return result
}