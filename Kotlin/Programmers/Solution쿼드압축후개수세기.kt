package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution쿼드압축후개수세기().solution(arrayOf
        (intArrayOf(1,1,0,0), intArrayOf(1,0,0,0), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))
    ).joinToString(", ")) //[4,9]
    println(Solution쿼드압축후개수세기().solution(arrayOf
        (intArrayOf(1,1,1,1,1,1,1,1), intArrayOf(0,1,1,1,1,1,1,1), intArrayOf(0,0,0,0,1,1,1,1), intArrayOf(0,1,0,0,1,1,1,1),
        intArrayOf(0,0,0,0,0,0,1,1), intArrayOf(0,0,0,0,0,0,0,1), intArrayOf(0,0,0,0,1,0,0,1), intArrayOf(0,0,0,0,1,1,1,1))
    ).joinToString(", ")) //[10, 15]
}

class Solution쿼드압축후개수세기 {
    var countZero = 0
    var countOne = 0
    fun solution(arr: Array<IntArray>): IntArray {
        countSum(arr)
        return intArrayOf(countZero, countOne)
    }

    fun countSum(arr: Array<IntArray>) {
        if(arr.all { it.all { num -> num == 0 } }) {
            countZero += 1
            return
        }
        if(arr.all { it.all { num -> num == 1 } }) {
            countOne += 1
            return
        }

        val mid = arr.size / 2
        countSum(Array(mid) { arr[it].sliceArray(0 until mid) })
        countSum(Array(mid) { arr[it].sliceArray(mid until arr[it].size) })
        countSum(Array(mid) { arr[it + mid].sliceArray(0 until mid) })
        countSum(Array(mid) { arr[it + mid].sliceArray(mid until arr[it].size) })
    }
}