package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution전력망을둘로나누기().solution(9, arrayOf(intArrayOf(1,3), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(4,6), intArrayOf(4,7), intArrayOf(7,8), intArrayOf(7,9)))) //3
    println(Solution전력망을둘로나누기().solution(4, arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4)))) //0
    println(Solution전력망을둘로나누기().solution(7, arrayOf(intArrayOf(1,2), intArrayOf(2,7), intArrayOf(3,7), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(6,7)))) //1
}

class Solution전력망을둘로나누기 {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = Integer.MAX_VALUE
        val graph = Array(n+1) { Array(n+1) { 0 } }
        for(wire in wires) {
            graph[wire[0]][wire[1]] = 1
            graph[wire[1]][wire[0]] = 1
        }

        fun dfs(node: Int, count: Int, visited: BooleanArray): Int {
            var resultCnt = count+1
            visited[node] = true
            for(i in 1 .. n) {
                if(graph[node][i] == 1 && !visited[i]) {
                    resultCnt = dfs(i, resultCnt, visited)
                }
            }
            return resultCnt
        }

        wires.forEach { wire ->
            graph[wire[0]][wire[1]] = 0
            graph[wire[1]][wire[0]] = 0
            val visited = BooleanArray(n+1) { false }
            answer = minOf(answer, kotlin.math.abs(dfs(wire[0], 0, visited)-dfs(wire[1], 0, visited)))
            graph[wire[0]][wire[1]] = 1
            graph[wire[1]][wire[0]] = 1
        }
        return answer
    }
}