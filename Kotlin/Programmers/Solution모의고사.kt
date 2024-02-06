package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution모의고사().solution(intArrayOf(1, 2, 3, 4, 5)).joinToString(", ")) //1
    println(Solution모의고사().solution(intArrayOf(1, 3, 2, 4, 2)).joinToString(", ")) //1, 2, 3
    println(Solution모의고사().solution(intArrayOf(1, 1, 1, 1, 1, 1)).joinToString(", ")) //1, 3
}

class Solution모의고사 {
    fun solution(answers: IntArray): IntArray {
        val noMaths = arrayListOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
        val person = IntArray(3)

        noMaths.forEachIndexed { index, noMath ->
            answers.forEachIndexed { i, answer ->
                if(answer == noMath[i % noMath.size]) {
                    person[index]++
                }
            }
        }
        return person.indices.filter { person[it] == person.maxOrNull() }.map { it + 1 }.sorted().toIntArray()
    }
}