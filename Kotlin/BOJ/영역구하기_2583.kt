package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    영역구하기_2583().solution()
}

class 영역구하기_2583 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m, k) = readLine().split(" ").map { it.toInt() }
        val spaces = Array(m) { IntArray(n) }
        repeat(k) {
            val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
            for(i in x1 until x2) {
                for(j in y1 until y2) {
                    spaces[i][j] = 1
                }
            }
        }

        val answer = mutableListOf<Int>()
        for(i in 0 until m) {
            for(j in 0 until n) {
                if(spaces[i][j] == 0) {
                    spaces[i][j] = 1
                    answer.add(emptySpace(i, j, spaces, 1))
                }
            }
        }

        answer.sort()
        println(answer.size)
        println(answer.joinToString(" "))
    }

    val dirX = listOf(1, -1, 0, 0)
    val dirY = listOf(0, 0, 1, -1)
    fun emptySpace(x: Int, y: Int, spaces: Array<IntArray>, spaceCnt: Int): Int {
        var count = spaceCnt
        for(d in dirX.indices) {
            val nx = x + dirX[d]
            val ny = y + dirY[d]
            if(nx in spaces.indices && ny in spaces[0].indices) {
                if(spaces[nx][ny] == 0) {
                    spaces[nx][ny] = 1
                    count = emptySpace(nx, ny, spaces, count+1)
                }
            }
        }
        return count
    }
}