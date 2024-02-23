package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution카펫().solution(10, 2).joinToString(", ")) //[4, 3]
    println(Solution카펫().solution(8, 1).joinToString(", ")) //[3, 3]
    println(Solution카펫().solution(24, 24).joinToString(", ")) //[8, 6]
}

class Solution카펫 {
    fun solution(brown: Int, yellow: Int): IntArray {
        for(i in yellow downTo 1) {
            if(yellow % i == 0) {
                if((i+2) * (yellow/i + 2) - yellow == brown) {
                    return intArrayOf(i + 2, yellow/i + 2)
                }
            }
        }
        return intArrayOf()
    }
}