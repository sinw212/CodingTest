package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    다리놓기_1010().solution()
}

class 다리놓기_1010 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val tc = readLine().toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        repeat(tc) {
            val (n, m) = readLine().split(" ").map { it.toInt() }
            var result = 1L
            for(i in 1 .. n) {
                result = result * (m-i+1) / i
            }
            bw.write("$result\n")
        }
        bw.flush()
        bw.close()
    }

    /*
    //다른 사람 코드 - 미리 조합을 계산해놓고 결과 구하는 방법
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val t = br.readLine().trim().toInt()
        val sb = StringBuilder()

        val dp = Array(31) { IntArray(31) { -1 } }
        for (i in 0..30) {
            dp[i][0] = 1
            dp[i][i] = 1
        }
        for (i in 2..30) {
            for (j in 1 until i) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            }
        }
        repeat(t) {
            val (x, y) = br.readLine().trim().split(' ').map { it.toInt() }
            sb.append(dp[y][x]).append('\n')
        }

        println(sb.toString())
    }
     */
}