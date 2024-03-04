package com.example.kotlincodingtest.programmers.running

fun main() {
    println(Solution하노이의탑().solution(2).joinToString(", ") { it.joinToString(",") }) //[[1,2],[1,3],[2,3]]
    println(Solution하노이의탑().solution(3).joinToString(", ") { it.joinToString(",") }) //[[1,3],[1,2],[3,2],[1,3],[2,1],[2,3],[1,3]
    println(Solution하노이의탑().solution(4).joinToString(", ") { it.joinToString(",") }) //[[1,2],[1,3],[2,3],[1,2],[3,1],[3,2],[1,2],[1,3],[2,3],[2,1],[3,1],[2,3],[1,2],[1,3],[2,3]]
}

class Solution하노이의탑 {
    var answer = arrayOf<IntArray>()
    fun solution(n: Int): Array<IntArray> {
        hanoi(n, 1, 2, 3)
        return answer
    }

    fun hanoi(num: Int, start: Int, via: Int, end: Int) {
        if(num == 1) {
            answer += intArrayOf(start, end)
            return
        }
        hanoi(num-1, start, end, via)
        answer += intArrayOf(start, end)
        hanoi(num-1, via, start, end)
    }
}