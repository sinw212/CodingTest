package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution숫자문자열과영단어().solution("one4seveneight")) //1478
    println(Solution숫자문자열과영단어().solution("23four5six7")) //234567
    println(Solution숫자문자열과영단어().solution("2three45sixseven")) //234567
    println(Solution숫자문자열과영단어().solution("123")) //123
}
class Solution숫자문자열과영단어 {
    fun solution(s: String): Int {
        var answer = s
        val numbers = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        numbers.forEachIndexed {index, number ->
            answer = answer.replace(number, index.toString(), false)
        }
        return answer.toInt()
    }
}