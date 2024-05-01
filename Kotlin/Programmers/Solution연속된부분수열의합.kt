package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution연속된부분수열의합().solution(intArrayOf(1,2,3,4,5), 7).joinToString(", ")) //[2,3]
    println(Solution연속된부분수열의합().solution(intArrayOf(1,1,1,2,3,4,5), 5).joinToString(", ")) //[6,6]
    println(Solution연속된부분수열의합().solution(intArrayOf(2,2,2,2,2), 6).joinToString(", ")) //[0,2]
}

class Solution연속된부분수열의합 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var startSy = 0
        var endSy = sequence.size
        var sum = 0
        var end = 0

        for(start in sequence.indices) {
            while(end < sequence.size && sum < k) {
                sum += sequence[end]
                end++
            }
            if(sum == k) {
                if(end-1-start < endSy - startSy) {
                    startSy = start
                    endSy = end - 1
                }
            }
            sum -= sequence[start]
        }
        return intArrayOf(startSy, endSy)
    }

    /*
    //아래 방법처럼 풀었을 때 일부 문제에서 시간 초과 발생 - 투포인터로 해결
    var startSy = 0
    var endSy = 0
    var maxSize = 0
    fun solution(sequence: IntArray, k: Int): IntArray {
        maxSize = sequence.size
        for(i in sequence.indices) {
            findSy(sequence, k, sequence[i], i, i, i)
        }
        return intArrayOf(startSy, endSy)
    }

    fun findSy(sequence: IntArray, k: Int, sum: Int, idx: Int, start: Int, end: Int) {
        if(sum > k) {
            return
        }
        if(sum == k) {
            if(end-start < maxSize) {
                startSy = start
                endSy = end
                maxSize = end - start
            } else if(end-start == maxSize) {
                if(start < startSy) {
                    startSy = start
                    endSy = end
                }
            }
            return
        }
        for(i in idx+1 until sequence.size) {
            findSy(sequence, k, sum+sequence[i], i, start, i)
        }
    }
     */
}