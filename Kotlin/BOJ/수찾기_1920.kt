package com.example.kotlincodingtest.baekjoon.running

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    수찾기_1920().solution()
}

class 수찾기_1920 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine(), " ")
        val nums = IntArray(n) { st.nextToken().toInt() }
        nums.sort()

        val m = readLine().toInt()
        st = StringTokenizer(readLine(), " ")
        val quests = IntArray(m) { st.nextToken().toInt() }

        for(quest in quests) {
            println(binarySearch(quest, nums))
        }
    }

    fun binarySearch(quest: Int, nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while(left <= right) {
            val mid = (left + right) / 2
            when {
                quest == nums[mid] -> return 1
                quest < nums[mid] -> right = mid - 1
                quest > nums[mid] -> left = mid + 1
            }
        }
        return 0
    }
}