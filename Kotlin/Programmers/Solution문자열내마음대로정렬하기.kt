package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution문자열내마음대로정렬하기().solution(arrayOf("sun", "bed", "car"), 1).joinToString(", ")) //["car", "bed", "sun"]
    println(Solution문자열내마음대로정렬하기().solution(arrayOf("abce", "abcd", "cdx"), 2).joinToString(", ")) //["abcd", "abce", "cdx"]
}

class Solution문자열내마음대로정렬하기 {
    fun solution(strings: Array<String>, n: Int): Array<String> =
        strings.sortedWith(compareBy<String> { it[n] }.thenBy { it }).toTypedArray()
}