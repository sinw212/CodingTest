package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    토마토_7576().solution()
}

class 토마토_7576 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (m, n) = readLine().split(" ").map { it.toInt() }
        val arr = Array(n) { Array(m) { 0 } }
        val queue = LinkedList<Pair<Int, Int>>()

        for(i in 0 until n) {
            val st = StringTokenizer(readLine(), " ")
            for(j in 0 until m) {
                arr[i][j] = st.nextToken().toInt()
                if(arr[i][j] == 1) {
                    queue.add(Pair(i, j))
                }
            }
        }

        val dirX = listOf(1, -1, 0, 0)
        val dirY = listOf(0, 0, 1, -1)
        var count = -1
        while(queue.isNotEmpty()) {
            for(i in 0 until queue.size) {
                val (x, y) = queue.poll()
                for(dir in dirX.indices) {
                    val nx = x + dirX[dir]
                    val ny = y + dirY[dir]
                    if(nx in 0 until n && ny in 0 until m && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1
                        queue.add(Pair(nx, ny))
                    }
                }
            }
            count++
        }

        if(arr.any { it.contains(0) }) println("-1") else println(count)
    }
}