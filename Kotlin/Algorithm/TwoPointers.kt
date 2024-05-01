package com.example.kotlincodingtest.algorithm

fun main() {
    println(TwoPointers().twoPointers(intArrayOf(3, 4, 2, 1, 2, 5, 3, 2), 10))
}

class TwoPointers {
    /**
     * 투 포인터(Two Pointers)
     */
    //예시) 배열에서 연속된 부분 수열의 합이 m인 경우의 수 찾기
    fun twoPointers(arr: IntArray, m: Int): Int {
        var count = 0
        var sum = 0
        var end = 0
        for(start in arr.indices) {
            while(end < arr.size && sum < m) {
                sum += arr[end]
                end++
            }
            if(sum == m) {
                count++
            }
            sum -= arr[start]
        }
        return count
    }
}