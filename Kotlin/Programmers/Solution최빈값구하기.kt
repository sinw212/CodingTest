package com.example.kotlincodingtest.programmers

fun main() {
    println(Solution최빈값구하기().solution(intArrayOf(1, 2, 2, 3, 3, 3, 4)))
}
class Solution최빈값구하기 {
    fun solution(array: IntArray): Int {
//        val maxNum = array.maxOrNull() ?: 0
//        var count = IntArray(maxNum + 1) {0}
//        for(i in array) {
//            count[i] += 1
//        }
//
//        val countMaxNum = count.maxOrNull() ?: 0
//        var max: Int = 0
//        for(c in count) {
//            if(c==countMaxNum) {
//                max++
//            }
//        }
//
//        if(max > 1) return -1 else return count.indexOf(countMaxNum)

        var map = mutableMapOf<Int, Int>()
        var maxCount = 0
        var answer = 0
        for(i in array) {
            map[i] = map.getOrDefault(i, 0)+1
            if(map[i]!! > maxCount) {
                maxCount = map[i]!!
                answer = i
            } else if(map[i]!! == maxCount) {
                answer = -1
            }
        }
        return answer

//        val list = array.groupBy { it }.entries.sortedByDescending { (_, value) -> value.size }
//        return if(list.size > 1 && (list[0].value.size == list[1].value.size)) -1 else list[0].key
    }
}