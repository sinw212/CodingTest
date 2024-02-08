package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val arr = Array(M) { Array(N) { ' ' } }
    val visited = Array(M) { Array(N) { false } }

    for(i in 0 until M) {
        val str = readLine()
        for(j in 0 until N) {
            arr[i][j] = str[j]
        }
    }

    var white = 0
    var blue = 0
    var whiteSum = 0
    var blueSum = 0
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    fun dfs(x: Int, y: Int) {
        visited[x][y] = true
        if(arr[x][y] == 'W') white++ else blue++
        for(i in dx.indices) {
            val dirX = x + dx[i]
            val dirY = y + dy[i]
            if(dirX in 0 until M && dirY in 0 until N) {
                if(arr[dirX][dirY] == arr[x][y] && !visited[dirX][dirY]) {
                    dfs(dirX, dirY)
                }
            }
        }
    }

    for(i in 0 until M) {
        for(j in 0 until N) {
            if(!visited[i][j]) {
                dfs(i, j)
                whiteSum += white*white
                blueSum += blue*blue
                white = 0
                blue = 0
            }
        }
    }

    println("$whiteSum $blueSum")
}