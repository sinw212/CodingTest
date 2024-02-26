package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution중복된문자제거().solution("people")) //"peol"
    println(Solution중복된문자제거().solution("We are the world")) //"We arthwold"
}

class Solution중복된문자제거 {
    fun solution(my_string: String): String = my_string.toList().distinct().joinToString("")
//    fun solution(my_string: String): String = my_string.toSet().joinToString("")
}