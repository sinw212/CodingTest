package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution3진법뒤집기().solution(45)) // 7
    println(Solution3진법뒤집기().solution(125)) //229
}
class Solution3진법뒤집기 {
    fun solution(n: Int): Int = n.toString(3).reversed().toInt(3)
}