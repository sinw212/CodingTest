package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution2개이하로다른비트().solution(longArrayOf(2, 7)).joinToString(", ")) //[3, 11]

    println(Solution2개이하로다른비트().solution(longArrayOf(11, 9)).joinToString(", ")) //[13, 10]
}

class Solution2개이하로다른비트 {
    fun solution(numbers: LongArray): LongArray {
        var answer = LongArray(numbers.size)
        for(i in numbers.indices) {
            val str = numbers[i].toString(2)
            answer[i] = (if(str.all { it == '1' }) {
               "10${str.substring(1)}"
            } else if(str.last() == '0') {
                "${str.substring(0, str.length-1)}1"
            } else {
                val idx = str.indexOfLast { it == '0' }
                "${str.substring(0, idx)}10" + if(idx != str.length - 2) str.substring(idx+2) else ""
            }).toLong(2)
        }
        return answer

        //다른 사람 코드 - 비트 연산 구현
        //return numbers.map { num -> (num.inv() and num + 1).let { num or it and (it shr 1).inv() } }.toLongArray()
    }
}