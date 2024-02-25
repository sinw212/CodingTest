package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution문자열내림차순으로배치하기().solution("Zbcdefg")) //gfedcbZ
}

class Solution문자열내림차순으로배치하기 {
    fun solution(s: String): String = s.toList().sortedDescending().joinToString("")
}