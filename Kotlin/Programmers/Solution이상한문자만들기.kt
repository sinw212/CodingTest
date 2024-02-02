package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution이상한문자만들기().solution("try hello world"))
}

class Solution이상한문자만들기 {
    fun solution(s: String): String {
        var answer = arrayOf<String>()
        s.split(" ").forEach { word ->
            var str = ""
            word.forEachIndexed { index, c ->
                str += if(index % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
            }
            answer += str
        }
        return answer.joinToString(" ")

        /*
        //다른 사람 풀이
        return s.split(" ").joinToString(" ") { word ->
            word.mapIndexed { index, c ->
                if(index % 2 == 0) c.uppercaseChar() else c.lowercaseChar()
            }.joinToString("")
        }
        */
    }
}