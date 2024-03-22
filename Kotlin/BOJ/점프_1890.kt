package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    점프_1890().solution()
}
class 점프_1890 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        val arr = Array(n) { intArrayOf() }
        repeat(n) {
            val st = StringTokenizer(readLine(), " ")
            arr[it] = IntArray(n) { st.nextToken().toInt() }
        }

        val dp = Array(n) { LongArray(n) { 0 } }
        dp[0][0] = 1
        for(i in 0 until n) {
            for(j in 0 until n) {
                if(i == n-1 && j == n-1) continue
                val jump = arr[i][j]
                if(i + jump < n) dp[i+jump][j] += dp[i][j]
                if(j + jump < n) dp[i][j+jump] += dp[i][j]
            }
        }
        println(dp[n-1][n-1])

        /*
        //BFS 방식 사용하면 메모리 초과 발생 -> DP 사용하여 수정
        val queue = LinkedList<JumpPoint>()
        queue.add(JumpPoint(0, 0))
        var count = 0L
        while(queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            if(x == n-1 && y == n-1) {
                count++
            } else {
                val jump = arr[x][y]
                if(x + jump in 0 until n) queue.add(JumpPoint(x+jump, y))
                if(y + jump in 0 until n) queue.add(JumpPoint(x, y+jump))
            }
        }
        println(count)
         */
    }
}