package com.example.kotlincodingtest.programmers

fun main() {
    var res = Solution배열만들기2().solution(7, 55)
    println(res.joinToString(", "))
}

class Solution배열만들기2 {
    fun solution(l: Int, r: Int): IntArray {
//        var arr = ArrayList<Int>()
//        for(i in l..r) {
//            var n: Int = i
//            var isFiveZero: Boolean = false
//            while(n>0) {
//                if(n % 10 == 5 || n % 10 == 0) {
//                    n /= 10
//                    isFiveZero = true
//                } else {
//                    isFiveZero = false
//                    break
//                }
//            }
//            if(isFiveZero) arr.add(i)
//        }
//        if(arr.size == 0) arr.add(-1)
//        return arr.toIntArray()

        return (l..r)
            .filter { it.toString().all { n -> n == '0' || n == '5' } }
            .let { if (it.isEmpty()) intArrayOf(-1) else it.toIntArray() }
    }
}