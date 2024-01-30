package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution네트워크().solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))) //2
    println(Solution네트워크().solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)))) //1
    println(Solution네트워크().solution(4, arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 1, 1, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 0, 1)))) //2
}

class Solution네트워크 {
    private var count = 0
    private var visited = booleanArrayOf()
    fun solution(n: Int, computers: Array<IntArray>): Int {
        visited = BooleanArray(n) { false }
        for(i in computers.indices) {
            computers[i][i] = 0
        }
        for(i in 0 until n) {
            if(!visited[i]) {
                count++
                dfs(computers, n, i)
            }
        }
        return count
    }

    private fun dfs(computers: Array<IntArray>, n: Int, node: Int) {
        visited[node] = true
        for(i in 0 until n) {
            if(computers[node][i] != 0 && !visited[i]) {
                dfs(computers, n, i)
            }
        }
    }
}