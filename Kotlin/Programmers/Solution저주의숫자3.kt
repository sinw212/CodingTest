package com.example.kotlincodingtest.programmers

fun main() {
    println(Solution저주의숫자3().solution(40))
}

class Solution저주의숫자3 {
    fun solution(n: Int) : Int {
        var answer: Int = 1
        for(i in 2..n) {
            while((answer+1) % 3 == 0 || (answer+1).toString().contains("3")) {
                answer++
            }
            answer++
        }
        return answer
    }
}