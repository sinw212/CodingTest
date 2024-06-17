package com.example.kotlincodingtest.codesignal.running

fun main() {
    println(CheckPalindrome().solution("aabaa")) //true
    println(CheckPalindrome().solution("abac")) //false
    println(CheckPalindrome().solution("a")) //true
}
class CheckPalindrome {
    fun solution(inputString: String): Boolean {
        return inputString == inputString.reversed()
    }
}