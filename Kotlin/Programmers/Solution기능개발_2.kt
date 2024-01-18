package com.example.kotlincodingtest.programmers.running

fun main() {
//    val arr = Solution기능개발_2().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
    val arr = Solution기능개발_2().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
    println(arr.joinToString(", "))
}

class Solution기능개발_2 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()

        var size = 0
        while(size < progresses.size) {
            for(i in progresses.indices) {
                progresses[i] += speeds[i]
            }
            var doneCount = 1
            if(progresses[size] >= 100) {
                size++
                for(j in size until progresses.size) {
                    if(progresses[j] >= 100) {
                        size++
                        doneCount++
                    } else {
                        break
                    }
                }
                answer = answer.plus(doneCount)
            }
        }
        return answer
    }
}