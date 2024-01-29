package com.example.kotlincodingtest.algorithm

import java.util.LinkedList

fun main() {
    println(DFSnBFS().dfs(1).joinToString(", "))
    println(DFSnBFS().bfs(1).joinToString(", "))
}

class DFSnBFS {
    private val v = 13
    private val nodes = arrayOf(intArrayOf(1, 2), intArrayOf(1, 8), intArrayOf(1, 9), intArrayOf(2, 3), intArrayOf(2, 6), intArrayOf(2, 7), intArrayOf(3, 4), intArrayOf(3, 5), intArrayOf(5, 7), intArrayOf(9, 10), intArrayOf(9, 11), intArrayOf(9, 12), intArrayOf(10, 13), intArrayOf(11, 13))
//    private val v = 5
//    private val nodes = arrayOf(intArrayOf(5, 4), intArrayOf(5, 2), intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(3, 1))
    private val graph = Array(v+1) { IntArray(v+1) }
    private val visited = BooleanArray(v+1) { false }
    private var result = intArrayOf()

    init {
        for(node in nodes) {
            graph[node[0]][node[1]] = 1
            graph[node[1]][node[0]] = 1
        }
    }

    /**
     * 깊이 우선 탐색(Depth-First Search)
     */
    fun dfs(node: Int): IntArray {
        result = result.plus(node)
        visited[node] = true

        for(i in 1 until v+1) {
            if(graph[node][i] != 0 && !visited[i]) {
                dfs(i)
            }
        }
        return result
    }

    /**
     * 너비 우선 탐색(Breadth-First Search)
     */
    fun bfs(start: Int): IntArray {
        result = IntArray(0)
        val queue = LinkedList<Int>()
        queue.add(start)
        visited[start] = true

        while(queue.isNotEmpty()) {
            val current = queue.poll()
            result = result.plus(current)
            for(i in 1 until v+1) {
                if(graph[current][i] != 0 && !visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
        return result
    }
}