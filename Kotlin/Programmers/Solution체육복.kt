package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution체육복().solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    println(Solution체육복().solution(5, intArrayOf(2, 4), intArrayOf(3)))
    println(Solution체육복().solution(3, intArrayOf(3), intArrayOf(1)))

    println(Solution체육복().solution(4, intArrayOf(1, 2), intArrayOf(1, 3)))
    println(Solution체육복().solution(5, intArrayOf(2, 4), intArrayOf(1, 3)))
    println(Solution체육복().solution(5, intArrayOf(2, 4), intArrayOf(3, 5)))
    println(Solution체육복().solution(5, intArrayOf(2, 4), intArrayOf(1, 5)))
}
class Solution체육복 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val clothes = IntArray(n) { 1 }
        lost.forEach { v -> clothes[v-1] -= 1 }
        reserve.forEach { v -> clothes[v-1] += 1}

        for(i in 0 until n) {
            if(clothes[i] == 0) {
                if(i > 0 && clothes[i-1] == 2) {
                    clothes[i-1]--
                    clothes[i]++
                } else if(i < n-1 && clothes[i+1] == 2) {
                    clothes[i+1]--
                    clothes[i]++
                }
            }
        }
        return clothes.count { it > 0 }

        /*
        //다른 사람 풀이
        var answer = n
        val lostSet = (lost.toSet() - reserve.toSet()).sorted()
        val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

        for (i in lostSet) {
            when {
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                else -> answer--
            }
        }
        return answer
         */
    }
}