package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution가장큰수().solution(intArrayOf(6, 10, 2)))
}

class Solution가장큰수 {
    fun solution(numbers: IntArray): String {
//        val arr = ArrayList<Pair<String, String>>()
//        for(i in numbers) {
//            val num = i.toString()
//            arr.add(Pair((num+num+num).substring(0, 3), num+num+num))
//        }
//        arr.sortWith(compareBy({ it.first }, { it.second } ))
//        arr.reverse()
//
//        var answer: String = ""
//        for(i in arr) {
//            val value = i.second
//            answer += value.substring(0, value.length/3)
//        }
//        return if(answer.substring(0, 1) == "0") "0" else answer

        var answer = ""
        numbers.sortedWith { num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2") }.forEach {
            answer += it
        }
        return if(answer.substring(0, 1) == "0") "0" else answer
    }
}