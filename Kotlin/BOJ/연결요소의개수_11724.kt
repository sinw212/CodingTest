package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n+1) { Array(n+1) { 0 } }
    val visited = BooleanArray(n+1) { false }
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u][v] = 1
        graph[v][u] = 1
    }

    fun dfs(node: Int) {
        visited[node] = true
        for(i in 1 .. n) {
            if(graph[node][i] == 1 && !visited[i]) {
                dfs(i)
            }
        }
    }

    var answer = 0
    for(i in 1..n) {
        if(!visited[i]) {
            dfs(i)
            answer++
        }
    }
    println(answer)
}

