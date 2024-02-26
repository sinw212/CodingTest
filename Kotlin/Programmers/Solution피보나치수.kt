package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution피보나치수().solution(3)) //2
    println(Solution피보나치수().solution(5)) //5
}

class Solution피보나치수 {
    fun solution(n: Int): Int {
        val arr = IntArray(n+1)
        arr[0] = 0
        arr[1] = 1
        for(i in 2 .. n) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567
        }
        return arr[n]
    }
}