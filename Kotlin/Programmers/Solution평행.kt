package com.example.kotlincodingtest.programmers

fun main() {
    println(Solution평행().solution(arrayOf(intArrayOf(3,5), intArrayOf(4,1), intArrayOf(2,4), intArrayOf(5,10))))
}

class Solution평행 {
    fun solution(dots: Array<IntArray>): Int {
        var arr = arrayOf(intArrayOf(0,1,2,3), intArrayOf(0,2,1,3), intArrayOf(0,3,1,2))
        for(i in arr) {
            var firstXMib = dots[i[2]][0] - dots[i[0]][0]
            var secondXMib = dots[i[3]][0] - dots[i[1]][0]
            var firstYMib = dots[i[2]][1] - dots[i[0]][1]
            var secondYMib = dots[i[3]][1] - dots[i[1]][1]
            if(secondXMib == secondYMib/firstYMib*firstXMib) return 1
            if(firstXMib == secondXMib && firstYMib == secondYMib) return 1
        }
        return 0
    }
}