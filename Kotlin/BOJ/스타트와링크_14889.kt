package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    스타트와링크_14889().solution()
}

class 스타트와링크_14889 {
    var minValue = Integer.MAX_VALUE
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = Array(n+1) { IntArray(n+1) }
        repeat(n) {
            val st = StringTokenizer(readLine(), " ")
            arr[it+1] = IntArray(n+1) {
                when(it) {
                    0 -> 0
                    else ->st.nextToken().toInt()
                }
            }
        }
        val visited = BooleanArray(n + 1) { false }
        visited[1] = true
        dfs(n, 0, arr, visited, 1)
        println(minValue)
    }

    fun dfs(n: Int, idx: Int, arr: Array<IntArray>, visited: BooleanArray, teamCount: Int) {
        if(teamCount == n/2) {
            var startTeam = intArrayOf()
            var linkTeam = intArrayOf()
            for(i in 1 .. n) {
                if(visited[i]) startTeam += i else linkTeam += i
            }
            minValue = minOf(minValue, kotlin.math.abs(calcScore(startTeam, arr) - calcScore(linkTeam, arr)))
            return
        }
        for(i in idx+1 until n) {
            if(!visited[i+1]) {
                visited[i+1] = true
                dfs(n, i, arr, visited, teamCount+1)
                visited[i+1] = false
            }
        }
    }

    fun calcScore(team: IntArray, arr: Array<IntArray>): Int {
        var sum = 0
        for (i in team.indices) {
            for (j in i + 1 until team.size) {
                sum += arr[team[i]][team[j]] + arr[team[j]][team[i]]
            }
        }
        return sum
    }
}