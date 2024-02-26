package com.example.kotlincodingtest.programmers.running

fun main() {
    println(SolutionA로B만들기().solution("olleh", "hello")) //1
    println(SolutionA로B만들기().solution("allpe", "apple")) //0
}

class SolutionA로B만들기 {
    fun solution(before: String, after: String): Int =
        if(before.toList().sorted() == after.toList().sorted()) 1 else 0
}