package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution문자열다루기기본().solution("a234")) //false
    println(Solution문자열다루기기본().solution("1234")) //true
}
class Solution문자열다루기기본 {
    fun solution(s: String): Boolean = ((s.length == 4 || s.length == 6) && (s.toIntOrNull() != null))
}