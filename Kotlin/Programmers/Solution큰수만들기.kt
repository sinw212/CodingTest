package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution큰수만들기().solution("1924", 2)) //94
    println(Solution큰수만들기().solution("1231234", 3)) //3234
    println(Solution큰수만들기().solution("4177252841", 4)) //775841
}
class Solution큰수만들기 {
    fun solution(number: String, k: Int): String {
        var answer = StringBuilder(number)
        var count = 0
        var index = 0
        while(index < answer.length) {
            var nextCount = 1
            while(nextCount < answer.length-index && answer[index] >= answer[index+nextCount]) {
                nextCount++
            }
            if(nextCount + count <= k) {
                answer = answer.delete(index, index+nextCount)
                count += nextCount
            } else {
                index++
            }
        }
        return answer.toString()
    }
}