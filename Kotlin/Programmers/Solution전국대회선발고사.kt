package com.example.kotlincodingtest.programmers

fun main() {
    println(
        Solution전국대회선발고사().solution(
            intArrayOf(3, 7, 2, 5, 4, 6, 1),
            booleanArrayOf(false, true, true, true, true, false, false)
        )
    )
}

class Solution전국대회선발고사 {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        val map = HashMap<Int, Int>()
        for(i in rank.indices) {
            map[rank[i]] = i
        }
        map.toSortedMap()
        var count: Int = 0
        val answer: IntArray = intArrayOf(0, 0, 0)
        for((key,value) in map) {
            if (attendance[value]) {
                answer[count] = value
                if (count == 2) break
                count++
            }
        }
        return 10000*answer[0] + 100*answer[1] + answer[2]

//        var result =
//            rank.mapIndexed { i, v -> i to v }
//                .filter { attendance[it.first] } //first : i, second : v
//                .sortedBy { it.second }
//        return result[0].first * 10000 + result[1].first * 100 + result[2].first
    }
}