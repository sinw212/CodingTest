package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution키패드누르기().solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right")) //"LRLLLRLLRRL"
    println(Solution키패드누르기().solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left")) //"LRLLRRLLLRR"
    println(Solution키패드누르기().solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right")) //"LLRLLRLLRL"
}

class Solution키패드누르기 {
    fun solution(numbers: IntArray, hand: String): String {
        val arr = mutableListOf(
            Pair(3, 1), Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 0),
            Pair(1, 1), Pair(1, 2), Pair(2, 0), Pair(2, 1), Pair(2, 2)
        )
        var left = Pair(3, 0)
        var right = Pair(3, 2)
        var answer = ""

        fun updateNum(num: Int, str: String) {
            answer += str
            if(str == "L") left = arr[num] else right = arr[num]
        }

        numbers.forEach { num ->
            when(num) {
                1, 4, 7 -> updateNum(num, "L")
                3, 6, 9 -> updateNum(num, "R")
                2, 5, 8, 0 -> {
                    val leftLength = kotlin.math.abs((arr[num].first - left.first)) + kotlin.math.abs((arr[num].second - left.second))
                    val rightLength = kotlin.math.abs((arr[num].first - right.first)) + kotlin.math.abs((arr[num].second - right.second))
                    if(leftLength == rightLength) {
                        if(hand == "right") updateNum(num, "R") else updateNum(num, "L")
                    } else {
                        if(leftLength > rightLength) updateNum(num, "R") else updateNum(num, "L")
                    }
                }
            }
        }
        return answer
    }
}