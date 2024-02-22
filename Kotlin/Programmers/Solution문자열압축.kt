package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution문자열압축().solution("aabbaccc")) //7
    println(Solution문자열압축().solution("ababcdcdababcdcd")) //9
    println(Solution문자열압축().solution("abcabcdede")) //8
    println(Solution문자열압축().solution("abcabcabcabcdededededede")) //14
    println(Solution문자열압축().solution("xababcdcdababcdcd")) //17

    println(Solution문자열압축().solution("12")) //2
}

class Solution문자열압축 {
    fun solution(s: String): Int {
        var minLength = s.length
        for(i in 1 .. s.length / 2) {
            var idx = i
            var num = s.substring(0, i)
            var numCount = 1
            var newList = ""
            while(idx < s.length) {
                if(idx + i > s.length) {
                    newList += if(numCount != 1) "$numCount$num" else num
                    numCount = 1
                    num = s.substring(idx, s.length)
                    break
                }
                if(num == s.substring(idx, idx + i)) {
                    numCount++
                } else {
                    newList += if(numCount != 1) "$numCount$num" else num
                    numCount = 1
                    num = s.substring(idx, idx + i)
                }
                idx += i
            }
            newList += if(numCount != 1) "$numCount$num" else num
            minLength = minOf(minLength, newList.length)
        }
        return minLength
    }
}