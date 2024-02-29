package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution피로도().solution(80, arrayOf(intArrayOf(80,20), intArrayOf(50,40), intArrayOf(30,10)))) //3
    println(Solution피로도().solution(4, arrayOf(intArrayOf(4,3), intArrayOf(2,2), intArrayOf(2,2)))) //2
    println(Solution피로도().solution(100, arrayOf(intArrayOf(100,1), intArrayOf(99,1), intArrayOf(99,1), intArrayOf(99,1), intArrayOf(99,1), intArrayOf(99,1), intArrayOf(99,1)))) //2
}

class Solution피로도 {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var maxValue = Integer.MIN_VALUE

        fun permutation(currentP: Int, count: Int, visited: BooleanArray) {
            if(count == dungeons.size) {
                maxValue = maxOf(maxValue, count)
                return
            }
            for(i in dungeons.indices) {
                if(!visited[i]) {
                    if(dungeons[i][0] > currentP) {
                        maxValue = maxOf(maxValue, count)
                    } else {
                        visited[i] = true
                        permutation(currentP - dungeons[i][1], count+1, visited)
                        visited[i] = false
                    }
                }
            }
        }

        for(i in dungeons.indices) {
            if(maxValue == dungeons.size) {
                return maxValue
            }
            val visited = BooleanArray(dungeons.size) { false }
            if(dungeons[i][0] <= k) {
                visited[i] = true
                permutation(k - dungeons[i][1], 1, visited)
                visited[i] = false
            }
        }
        return maxValue
    }
}