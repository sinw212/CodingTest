package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { Array(n + 1) { 0 } }

    for (i in 1..n) {
        val st = StringTokenizer(readLine(), " ")
        for (j in 1..st.countTokens()) {
            dp[i][j] = st.nextToken().toInt()
        }
    }
    for (i in 2..n) {
        for (j in 1..i) {
            dp[i][j] = dp[i][j] + maxOf(dp[i - 1][j - 1], dp[i - 1][j])
        }
    }
    println(dp[n].max())
}

/*
//dfs로 구현하면 시간초과 발생 - DP 사용하여 수정
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arrs = Array(n) { intArrayOf() }
    repeat(n) { rp ->
        arrs[rp] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    println(dfs(n, 1, 0, arrs, arrs[0][0]))
}

var maxCount = Integer.MIN_VALUE
fun dfs(n: Int, num: Int, idx: Int, arrs: Array<IntArray>, count: Int): Int {
    if(num == n) {
        maxCount = maxOf(maxCount, count)
        return maxCount
    }

    maxCount = dfs(n, num+1, idx, arrs, count + arrs[num][idx])
    maxCount = dfs(n, num+1, idx+1, arrs, count + arrs[num][idx+1])

    return maxCount
}
 */