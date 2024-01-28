package com.example.kotlincodingtest.programmers.running

import kotlin.math.*

fun main() {
    println(SolutionHIndex().solution(intArrayOf(3, 0, 6, 1, 5))) //3
    println(SolutionHIndex().solution(intArrayOf(8, 7, 6, 2, 1))) //3
    println(SolutionHIndex().solution(intArrayOf(8, 2, 7, 2, 1))) //2
    println(SolutionHIndex().solution(intArrayOf(9, 3, 6, 7, 1))) //3
    println(SolutionHIndex().solution(intArrayOf(0, 0, 0))) //0
    println(SolutionHIndex().solution(intArrayOf(3, 4))) //2
}

class SolutionHIndex {
    fun solution(citations: IntArray): Int {
        val sortArr = citations.sortedArray()
        var maxIndex = -1
        for (i in sortArr.indices) {
            if (sortArr.size - i > sortArr[i]) {
                maxIndex = i
            } else if (sortArr.size - i == sortArr[i]) {
                return sortArr[i]
            } else break
        }

        return if (maxIndex == -1) sortArr.size
        else if (maxIndex < sortArr.size - 1) {
            (sortArr[maxIndex + 1] downTo sortArr[maxIndex]).filter { it <= sortArr.size - (maxIndex + 1) }.firstOrNull() ?: 1
        } else sortArr[maxIndex]

        /*
        //다른 사람 풀이
        return citations.sortedDescending().mapIndexed { idx, item -> min(idx + 1, item) }.max()
         */
    }
}