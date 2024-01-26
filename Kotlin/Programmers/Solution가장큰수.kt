package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution가장큰수().solution(intArrayOf(6, 10, 2))) //6210
    println(Solution가장큰수().solution(intArrayOf(3, 30, 34, 5, 9))) //9534330
    println(Solution가장큰수().solution(intArrayOf(0, 0, 0))) //0
    println(Solution가장큰수().solution(intArrayOf(555, 565, 566, 55, 56, 5, 54, 544, 549))) //5665656555555554954544
    println(Solution가장큰수().solution(intArrayOf(1000, 111, 110, 101, 100, 11, 10, 1, 0))) //1111111101011010010000
}

class Solution가장큰수 {
    fun solution(numbers: IntArray): String {
        val answer = numbers.sortedWith(Comparator { num1: Int, num2: Int ->
            ("$num2$num1").compareTo("$num1$num2")
        }).joinToString("")
        return if(answer.substring(0, 1) == "0") "0" else answer

        /*
        //substring 대신 정규식 사용해서 거르는 방법
        if ("(0*)".toRegex().replace(answer, "").isEmpty()) {
            answer = "0"
        }
         */

        /*
        //버블정렬 사용 - 시간초과
        val strNum = numbers.map { it.toString() }.toTypedArray()
        for(i in 0 until numbers.size - 1) {
            for(j in 0 until numbers.size - 1 - i) {
                if(strNum[j]+strNum[j+1] < strNum[j+1]+strNum[j]) {
                    val temp = strNum[j]
                    strNum[j] = strNum[j+1]
                    strNum[j+1] = temp
                }
            }
        }
        val answer = strNum.joinToString("")
        return if(answer.substring(0, 1) == "0") "0" else answer
         */
    }
}