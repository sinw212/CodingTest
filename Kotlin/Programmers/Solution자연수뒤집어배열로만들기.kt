package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution자연수뒤집어배열로만들기().solution(12345).joinToString(", "))
}

class Solution자연수뒤집어배열로만들기 {
    fun solution(n: Long): IntArray {
        var answer = intArrayOf()
        n.toString().reversed().map {
            answer += it.code - '0'.code
        }
        return answer

//        //다른 사람 풀이 (한줄 코드)
//        return n.toString().reversed().map { it.toString().toInt() }.toIntArray()
    }
}