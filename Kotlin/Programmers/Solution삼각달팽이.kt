package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution삼각달팽이().solution(4).joinToString(", ")) //[1,2,9,3,10,8,4,5,6,7]
    println(Solution삼각달팽이().solution(5).joinToString(", ")) //[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
    println(Solution삼각달팽이().solution(6).joinToString(", ")) //[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
    println(Solution삼각달팽이().solution(8).joinToString(", ")) //[1,2,21,3,22,20,4,23,33,19,5,24,34,32,18,6,25,35,36,31,17,7,26,27,28,29,30,16,8,9,10,11,12,13,14,15]
}
class Solution삼각달팽이 {
    fun solution(n: Int): IntArray {
        var num = 1
        val arr = Array(n) { IntArray(n) }
        val numSize = countNum(n)
        for(i in 0 until n) {
            for(j in 2 * i until n - i) {
                arr[j][i] = num++
                if(num > numSize) break
            }
            for(j in i + 1 until n - (2 * i)) {
                arr[n - i - 1][j] = num++
                if(num > numSize) break
            }
            var xCnt = n - 2 - i
            var yCnt = n - 2 * (i + 1)
            for(j in 1 .. n - 2 - (3 * i)) {
                arr[xCnt--][yCnt--] = num++
                if(num > numSize) break
            }
        }
        return arr.flatMap { it.asIterable() }.filter { it > 0 }.toIntArray()
    }

    private fun countNum(n: Int): Int {
        var sum = 0
        for(i in 1 .. n) {
            sum += i
        }
        return sum
    }
}