package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n) { "" }
    val visited = Array(n) { Array(n) { 0 } }
    repeat(n) {
        arr[it] = readLine()
    }
    var answer = intArrayOf()
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(arr[i][j] == '1' && visited[i][j] == 0) {
                visited[i][j] = 1
                answer += calcCount(i, j, n, arr, visited, 0)
            }
        }
    }
    println(answer.size)
    answer.sorted().forEach { println(it) }
}

val dirX = listOf(1, -1, 0, 0)
val dirY = listOf(0, 0, 1, -1)
fun calcCount(i: Int, j: Int, n: Int, arr: Array<String>, visited: Array<Array<Int>>, count: Int): Int {
    var cnt = count + 1
    for(dir in dirX.indices) {
        val nx = i + dirX[dir]
        val ny = j + dirY[dir]
        if(nx in 0 until n && ny in 0 until n) {
            if(arr[nx][ny] == '1' && visited[nx][ny] == 0) {
                visited[nx][ny] = 1
                cnt = calcCount(nx, ny, n, arr, visited, cnt)
            }
        }
    }
    return cnt
}