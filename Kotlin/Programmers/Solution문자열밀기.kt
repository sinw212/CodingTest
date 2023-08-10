package com.example.kotlincodingtest.programmers

fun main() {
    println(Solution문자열밀기().solution("hello", "ohell"))
}
class Solution문자열밀기 {
    fun solution(A: String, B: String): Int {
        var str = A
        var answer: Int = 0
        while(str != B) {
            if(answer >= A.length-1) return -1
            str = str.last()+str.substring(0, str.length-1)
            answer++
        }
        return answer

//        return (B+B).indexOf(A)
    }
}