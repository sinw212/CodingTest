package com.example.kotlincodingtest.programmers.pushdone

fun main() {
    var res = Solution배열두배만들기().solution(intArrayOf(1, 2, 3, 4, 5))
    println(res.joinToString(", "))
}
class Solution배열두배만들기 {
    fun solution(numbers: IntArray) = numbers.map { it * 2 }
}