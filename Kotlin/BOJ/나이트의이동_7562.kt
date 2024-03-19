package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    나이트의이동_7562().solution()
}

class 나이트의이동_7562 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val num = readLine().toInt()
        val dirX = listOf(-1, 1, 2, 2, 1, -1, -2, -2)
        val dirY = listOf(2, 2, 1, -1, -2, -2, -1, 1)

        repeat(num) {
            val len = readLine().toInt()
            val (srtX, srtY) = readLine().split(" ").map { it.toInt() }
            val (tarX, tarY) = readLine().split(" ").map { it.toInt() }

            val queue = LinkedList<Pair<ChessPoint, Int>>()
            val visited = Array(len) { Array(len) { 0 } }
            queue.add(Pair(ChessPoint(srtX, srtY), 0))
            visited[srtX][srtY] = 1
            while(queue.isNotEmpty()) {
                val (curChess, time) = queue.poll()
                val (curX, curY) = curChess
                if(curX == tarX && curY == tarY) {
                    println(time)
                    break
                }
                for(dir in dirX.indices) {
                    val nx = curX + dirX[dir]
                    val ny = curY + dirY[dir]
                    if(nx in 0 until len && ny in 0 until len && visited[nx][ny] == 0) {
                        queue.add(Pair(ChessPoint(nx, ny), time+1))
                        visited[nx][ny] = 1
                    }
                }
            }
        }
    }
}

data class ChessPoint(val x: Int, val y: Int)