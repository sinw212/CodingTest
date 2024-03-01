package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution행렬의곱셈().solution(
        arrayOf(intArrayOf(1,4), intArrayOf(3,2), intArrayOf(4,1)),
        arrayOf(intArrayOf(3,3), intArrayOf(3,3))
    ).joinToString(" / ") { it.joinToString(",") }) //[[15, 15], [15, 15], [15, 15]]
    println(Solution행렬의곱셈().solution(
        arrayOf(intArrayOf(2,3,2), intArrayOf(4,2,4), intArrayOf(3,1,4)),
        arrayOf(intArrayOf(5,4,3), intArrayOf(2,4,1), intArrayOf(3,1,1))
    ).joinToString(" / ") { it.joinToString(",") }) //[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
}

class Solution행렬의곱셈 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }
        for(i in arr1.indices) {
            for(j in arr2[0].indices) {
                for(k in arr1[0].indices) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }
        return answer

        //아래와 같은 방법으로도 표현할 수 있음
        /*
        return Array(arr1.size) { i->
            IntArray(arr2[0].size) { j->
                var value = 0
                for(k in arr1[0].indices) {
                    value += arr1[i][k] * arr2[k][j]
                }
                value
            }
        }
         */
    }
}