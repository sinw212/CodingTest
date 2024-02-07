package com.example.kotlincodingtest.algorithm

fun main() {
    println(Combinatorics().permutation(mutableListOf()))
    println(Combinatorics().dupPermutation(mutableListOf()))
    println(Combinatorics().combination(0,mutableListOf()))
    println(Combinatorics().dupCombination(0, mutableListOf()))
}

class Combinatorics {
    private var k = 2 // 뽑을 숫자 개수
    private var arr = listOf(1, 2, 2, 3) // 뽑을 리스트
    var count = 0

    /**
     * 순열 (arr.size P k)
     */
    fun permutation(result: MutableList<Int>, visited: BooleanArray = BooleanArray(arr.size) { false }): Int {
        if (result.size == k) {
            println(result)
            return count++
        }

        for (i in arr.indices) {
            if (!visited[i]) {
                result.add(arr[i])
                visited[i] = true
                permutation(result, visited)
                visited[i] = false
                result.removeLast()
            }
        }
        return count
    }

    /**
     * 중복 순열
     */
    fun dupPermutation(result: MutableList<Int>): Int {
        if (result.size == k) {
            println(result)
            return count++
        }

        for (i in arr.indices) {
            result.add(arr[i])
            dupPermutation(result)
            result.removeLast()
        }
        return count
    }

    /**
     * 조합 (arr.size C k)
     */
    fun combination(start: Int, result: MutableList<Int>): Int {
        if (result.size == k) {
            println(result)
            return count++
        }

        for (i in start until arr.size) {
            result.add(arr[i])
            combination(i + 1, result)
            result.removeLast()
        }
        return count
    }

    /**
     * 중복 조합
     */
    fun dupCombination(start: Int, result: MutableList<Int>): Int {
        if(result.size == k){
            println(result)
            return count++
        }

        for(i in start until arr.size){
            result.add(arr[i])
            dupCombination(i, result)
            result.removeLast()
        }
        return count
    }
}