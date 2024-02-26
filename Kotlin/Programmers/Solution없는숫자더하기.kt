package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution없는숫자더하기().solution(intArrayOf(1,2,3,4,6,7,8,0))) //14
    println(Solution없는숫자더하기().solution(intArrayOf(5,8,4,0,6,7,9))) //6
}

class Solution없는숫자더하기 {
    fun solution(numbers: IntArray): Int {
        val hashMap = hashMapOf<Int, Int>()
        for(i in 0 .. 9) {
            hashMap[i] = 0
        }
        numbers.forEach {
            hashMap[it] = 1
        }
        var answer = 0
        for((key, value) in hashMap) {
            if(value == 0) answer += key
        }
        return answer

        //다른 사람 풀이
        //return (0 .. 9).filterNot(numbers::contains).sum()
    }
}