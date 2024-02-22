package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution이진변환반복하기().solution("110010101001").joinToString(", ")) //[3, 8]
    println(Solution이진변환반복하기().solution("01110").joinToString(", ")) //[3, 3]
    println(Solution이진변환반복하기().solution("1111111").joinToString(", ")) //[4, 1]
}

class Solution이진변환반복하기 {
    fun solution(s: String): IntArray {
        var transCnt = 0
        var zeroCnt = 0
        var str = s
        while(str != "1") {
            zeroCnt += str.count { it == '0' }
            str = str.replace("0", "").length.toString(2)
            transCnt += 1
        }
        return intArrayOf(transCnt, zeroCnt)
    }
}