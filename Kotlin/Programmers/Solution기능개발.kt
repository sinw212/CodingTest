package com.example.kotlincodingtest.programmers.running

fun main() {
    val arr = Solution기능개발().solution(intArrayOf(90, 90, 90, 90), intArrayOf(30, 1, 1, 1))
    println(arr.joinToString(", "))
}

class Solution기능개발 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        var i = 0
        while(i < progresses.size) {
            while (progresses[i] < 100) {
                for (j in i until progresses.size) {
                    progresses[j] += speeds[j]
                }
            }
            var count = 1
            i++
            while(i < progresses.size && progresses[i] >= 100) {
                count++
                i++
            }
            answer.add(count)
        }
        return answer.toIntArray()
    }
}
