package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution_입국심사().solution(6, intArrayOf(7, 10))) //28
}

class Solution_입국심사 {
    fun solution(n: Int, times: IntArray): Long {
        times.sort()
        var left = times[0].toLong()
        var right = times[times.size-1].toLong() * n
        while(left <= right) {
            val mid = (left + right) / 2
            var count = 0L
            times.forEach {
                count += (mid / it)
            }
            when {
                count >= n -> right = mid - 1
                count < n -> left = mid + 1
            }
        }
        return left
    }
}