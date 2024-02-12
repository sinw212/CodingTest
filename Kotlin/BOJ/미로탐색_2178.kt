package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

data class Point(val x: Int, val y: Int)

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { Array(m) { 0 } }
    repeat(n) { x ->
        val str = readLine()
        repeat(m) { y ->
            arr[x][y] = str[y] - '0'
        }
    }

    bfs(n, m, arr)
}

fun bfs(n: Int, m: Int, arr: Array<Array<Int>>) {
    val queue: Queue<Point> = LinkedList()
    val visited = Array(n) { Array(m) { 0 } }

    queue.add(Point(0, 0))
    visited[0][0] = 1

    while(queue.isNotEmpty()) {
        val current = queue.poll()
        for(i in dx.indices) {
            val dirX = current.x + dx[i]
            val dirY = current.y + dy[i]
            if(dirX in 0 until n && dirY in 0 until m && visited[dirX][dirY] == 0 && arr[dirX][dirY] == 1) {
                //visited[dirX][dirY] != 0 은 이미 한번 지나간 적이 있다는 의미
                queue.add(Point(dirX, dirY))
                visited[dirX][dirY] = visited[current.x][current.y] + 1
                if(dirX == n - 1 && dirY == m - 1) {
                    println(visited[dirX][dirY])
                    break
                }
            }
        }
    }
}

