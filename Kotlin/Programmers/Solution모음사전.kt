package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution모음사전().solution("AAAAE")) //6
    println(Solution모음사전().solution("AAAE")) //10
    println(Solution모음사전().solution("I")) //1563
    println(Solution모음사전().solution("EIO")) //1189
}

class Solution모음사전 {
    fun solution(word: String): Int {
        val alphabet = arrayOf("A", "E", "I", "O", "U")
        var isStop = false

        var answer = 0
        fun countText(str: String) {
            answer++
            if(str == word) {
                isStop = true
                return
            }
            if(str.length == alphabet.size) {
                return
            }
            for(i in alphabet.indices) {
                if(isStop) {
                    return
                }
                countText(str + alphabet[i])
            }
        }

        for(i in alphabet.indices) {
            if(isStop) {
                return answer
            }
            countText(alphabet[i])
        }
        return -1
    }
}