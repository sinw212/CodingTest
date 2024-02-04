package com.example.kotlincodingtest.algorithm

fun main() {
    println(Search().bruteForceSearch(intArrayOf(1, 4, 6, 8, 2, 9), 14))
    println(Search().backtracking(intArrayOf(1, 2, 3, 4), 3, 0, mutableListOf()))
    println(Search().binarySearch(intArrayOf(1, 4, 6, 8, 2, 9), 8))
}

class Search {
    /**
     * 완전 탐색(Exhaustive Search) 중 브루트포스(Brute-force)
     */
    //예시) 배열에서 주어진 합을 갖는 부분 배열의 시작과 끝 인덱스의 합 구하기
    fun bruteForceSearch(arr: IntArray, targetSum: Int): Int {
        for (i in arr.indices) {
            var sum = 0
            for (j in i until arr.size) {
                sum += arr[j]
                if (sum == targetSum) {
                    return i + j
                } else if (sum > targetSum) {
                    break
                }
            }
        }
        return -1
    }

    /**
     * 완전 탐색(Exhaustive Search) 중 백트래킹(backtracking)
     */
    //에시) 배열에서 크기가 k인 조합 개수 구하기
    var count = 0
    fun backtracking(arr: IntArray, k: Int, start: Int, result: MutableList<Int>): Int {
        if(result.size == k) {
            println(result)
            return count++
        }
        
        for(i in start until arr.size) {
            result.add(arr[i])
            backtracking(arr, k, i+1, result)
            result.removeAt(result.size - 1)
        }
        return count
    }

    /**
     * 이진 탐색(Binary Search)
     */
    fun binarySearch(arr: IntArray, target: Int): Int {
        arr.sort()
        var left = 0
        var right = arr.size - 1

        while(left <= right) {
            val mid = (left + right) / 2
            when {
                arr[mid] == target -> return mid
                arr[mid] < target -> left = mid + 1
                arr[mid] > target -> right = mid - 1
            }
        }
        return -1
    }
}