package com.example.kotlincodingtest.programmers.pushdone

fun main() {
    var res = Solution분수의덧셈().solution(9, 2, 1, 3)
    println(res.joinToString(", "))
}

class Solution분수의덧셈 {
    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
//        val sumNumer = (numer1 * denom2) + (numer2 * denom1)
//        val sumDenom = denom1 * denom2
//        val maxValue = if(sumNumer > sumDenom) sumNumer else sumDenom
//
//        var resultNumer = sumNumer
//        var resultDenom = sumDenom
//        for(i in 2..maxValue) {
//            if(sumNumer % i == 0 && sumDenom % i == 0) {
//                resultNumer = sumNumer / i
//                resultDenom = sumDenom / i
//            }
//        }
//        return intArrayOf(resultNumer, resultDenom)

        return intArrayOf(numer1 * denom2 + numer2 * denom1, denom1 * denom2).apply {
            gcd(this[0], this[1])
                .let {gcdValue ->
                    this[0] /= gcdValue
                    this[1] /= gcdValue
                }
        }
    }

    fun gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
}