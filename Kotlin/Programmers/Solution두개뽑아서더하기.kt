package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution두개뽑아서더하기().solution(intArrayOf(2,1,3,4,1)).joinToString(", ")) //[2,3,4,5,6,7]
    println(Solution두개뽑아서더하기().solution(intArrayOf(5,0,2,7)).joinToString(", ")) //[2,5,7,9,12]
}

class Solution두개뽑아서더하기 {
    fun solution(numbers: IntArray): IntArray {
        val mutableSet = mutableSetOf<Int>()
        for(i in numbers.indices) {
            for(j in i + 1 until numbers.size) {
                mutableSet.add(numbers[i] + numbers[j])
            }
        }
        return mutableSet.sorted().toIntArray()
    }
}