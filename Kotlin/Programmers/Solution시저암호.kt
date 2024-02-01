package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution시저암호().solution("AB", 1)) //"BC"
    println(Solution시저암호().solution("z", 1)) //"a"
    println(Solution시저암호().solution("a B z", 4)) //"e F d"
}
class Solution시저암호 {
    fun solution(s: String, n: Int): String {
        return s.toCharArray().map {
            when(it) {
                in 'A'..'Z' -> if(it + n > 'Z') it + n - 26 else it + n
                in 'a' .. 'z' -> if(it + n > 'z') it + n - 26 else it + n
                else -> it
            }
        }.joinToString("")
    }
}