package com.example.kotlincodingtest.algorithm

fun main() {
    println(DP().dynamicProgramming(10))
}

class DP {
    /**
     * 동적 계획법(Dynamic Programming)
     */
    //예시) 피보나치 수열의 N번째 수 구하기
    fun dynamicProgramming(n: Int): Long {
        val dp = LongArray(n + 1)
        dp[0] = 0
        dp[1] = 1

        for(i in 2 .. n) {
            dp[i] = dp[i-2] + dp[i-1]
        }
        return dp[n]
    }
}